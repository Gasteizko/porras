package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.PossibleBet;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import es.ucm.fdi.porras.model.dto.PorraBet;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.PossibleBetRepository;
import es.ucm.fdi.porras.repository.UserPorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.service.PorraService;
import es.ucm.fdi.porras.service.UserService;
import es.ucm.fdi.porras.utils.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Controller
@Slf4j
public class PorraController {

    private PorraService porraService;

    private UserService userService;

    private UserRepository userRepository;

    private PorraRepository porraRepository;

    private UserPorraRepository userPorraRepository;

    private PossibleBetRepository possibleBetRepository;

    public PorraController(PorraService porraService, UserService userService, UserRepository userRepository,
                           PorraRepository porraRepository, UserPorraRepository userPorraRepository,
                           PossibleBetRepository possibleBetRepository) {
        this.porraService = porraService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.porraRepository = porraRepository;
        this.userPorraRepository = userPorraRepository;
        this.possibleBetRepository = possibleBetRepository;
    }

    @RequestMapping(value = {"/porra/{id}", "/porra"}, method = RequestMethod.GET)
    public String getPorra(@PathVariable("id") Long id, Principal principal, Model model) {
        if (id == null ) {
            log.warn("Null id");
            return "porra";
        }
        Porra p = porraRepository.findOne(id);
        if (p == null) {
            log.error("No such porra: {}", id);
        } else {
            model.addAttribute("porra", p);
        }
        List<User> ps = userRepository.findAllParticipantsByPorraId(id);

        List<PorraBet> bp = new ArrayList<PorraBet>();
        for (int i = 0; i < ps.size(); i++) {
            PorraBet porraBet = new PorraBet();
            porraBet.setLogin(ps.get(i).getLogin());
            UserPorra up = userPorraRepository.findAllByIdPorra(id, ps.get(i).getId());
            porraBet.setBet(up.getBet());
            porraBet.setBetAmount(up.getBetAmount());
            bp.add(porraBet);
        }

        model.addAttribute("p", p);
        model.addAttribute("bp", bp);

        return "porra";
    }

    @RequestMapping(value = "/newPorra", method = RequestMethod.GET)
    public String showNewPorraForm(Model model) {
        PorraForm porraForm = new PorraForm();
        model.addAttribute("porra", porraForm);
        return "newPorra";
    }

    @RequestMapping(value = "/newPorration", method = RequestMethod.POST)
    public RedirectView newPorrita(@ModelAttribute("porraForm") @Valid PorraForm porraForm,
                                   BindingResult result, final Errors errors, Principal principal) {
        /*if (result.hasErrors()) {
            log.warn("New Porra error:",  errors.getAllErrors().toString());
            return new RedirectView("/newPorra?error");
        }*/
        log.info("Registering new porra: {}", porraForm);
        String nameUser = principal.getName();
        User currentUser = userRepository.findByLogin(nameUser);
        Porra createdPorra = new Porra();
        createdPorra.setTitle(porraForm.getTituloPorra());
        createdPorra.setCreator(currentUser);
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = porraForm.getFinishTime();
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }

        log.info(fecha.toString());
        createdPorra.setType(porraForm.getTipoPorra());
        createdPorra.setFinishTime(fecha);
        createdPorra.setDescription(porraForm.getDescripcionPorra());

        createdPorra = porraRepository.save(createdPorra);

        return new RedirectView("/dash");
    }

    @GetMapping(value = "/listaporras")
    public String listaporras(
            @RequestParam(value = "latest", required = false) Boolean latest,
            @RequestParam(value = "winned", required = false) Boolean winned,
            @RequestParam(value = "losses", required = false) Boolean losses,
            @RequestParam(value = "mine", required = false) Boolean mine, Principal principal, Model model) {

        User currentUser = userRepository.findByLogin(principal.getName());

        Collection<Porra> porras = null;
        if (latest != null){
            log.info("Getting latest porras");
            porras = porraRepository.findAllByOrderByCreatedTimeDesc();
        }
        else if (winned != null) {
            log.info("Getting winned porras");
            porras = porraRepository.findAllByUserIdAndWinned(currentUser.getId(), true);
        }
        else if (losses != null){
            log.info("Getting losses porras");
            porras = porraRepository.findAllByUserIdAndWinned(currentUser.getId(), false);
        }
        else if (mine != null) {
            log.info("Getting mine porras");
            porras = porraRepository.findAllByCreatorId(currentUser.getId());
        }
        else {
            porras = porraRepository.findAll();
        }
        model.addAttribute("porras", porras);

        return "listaporras";
    }

}
