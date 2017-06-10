package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.*;
import es.ucm.fdi.porras.model.dto.PorraBet;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.UserPorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.service.PorraService;
import es.ucm.fdi.porras.service.UserService;
import es.ucm.fdi.porras.storage.StorageService;
import es.ucm.fdi.porras.utils.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final StorageService storageService;

    private PasswordEncoder passwordEncoder;


    public PorraController(PorraService porraService, UserService userService, UserRepository userRepository,
                           PorraRepository porraRepository, StorageService storageService, UserPorraRepository userPorraRepository, PasswordEncoder passwordEncoder) {
        this.porraService = porraService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.porraRepository = porraRepository;
        this.userPorraRepository = userPorraRepository;
        this.storageService = storageService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = {"/porra"}, method = RequestMethod.GET)
    public RedirectView getPorra(Principal principal, Model model) {

        // If try to access /porra without the id redirect to dash
        return new RedirectView("/dash");
    }

    @RequestMapping(value = {"/porra/{id}"}, method = RequestMethod.GET)
    public String getPorraById(@PathVariable("id") Long id, Principal principal, Model model) {
        if (id == null ) {
            log.warn("Null id");
            return "porra";
        }
        Porra p = porraRepository.findOne(id);
        if (p == null) {
            log.error("No such porra: {}", id);
        } else {
            model.addAttribute("p", p);
        }
        return "porra";
    }

    @RequestMapping(value = "/betPorra/{id}", method = RequestMethod.POST)
    public RedirectView insertNewPorra(@PathVariable("id") Long id,
                                      @RequestParam(value="betstring", required=false) String bet,
                                      @RequestParam(value="betamount", required=false) String amount,
                                       Model model, Principal principal) {

        if (!bet.isEmpty() && !amount.isEmpty()) {
            UserPorra up = new UserPorra();
            up.setBet(bet);
            up.setBetAmount(Double.parseDouble(amount));
            User user = userRepository.findByLogin(principal.getName());
            up.setUser(user);
            Porra porra = porraRepository.findOneById(id);
            up.setPorra(porra);
            UserPorraId userPorraId = new UserPorraId(user.getId(), porra.getId());
            up.setUserPorraId(userPorraId);
            userPorraRepository.save(up);
        } else {
            log.error("No valid data: {}", id);
        }

        String url = "/porra/" + id;
        return new RedirectView(url);
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
        if (result.hasErrors()) {
            log.warn("New Porra error:",  errors.getAllErrors().toString());
            return new RedirectView("/newPorra?error");
        }
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
        createdPorra.setEquipoLocal(porraForm.getEquipoLocal());
        createdPorra.setEquipoVisitante(porraForm.getEquipoVisitante());
        createdPorra.setTipoApuesta(porraForm.getTipoApuesta());
        createdPorra.setMinBet(porraForm.getMinBet());
        createdPorra.setApuestaOpen(porraForm.getApuestaOpen());
        //createdPorra.setContrasenya(porraForm.getContrasenya());
        createdPorra.setContrasenya(passwordEncoder.encode(porraForm.getContrasenya()));
        if(porraForm.getFile().isEmpty() == false) {
            storageService.store(porraForm.getFile(), porraForm.getTituloPorra() + ".jpg");
            createdPorra.setImageUrl(porraForm.getTituloPorra() + ".jpg");
        }

        Porra p = porraRepository.save(createdPorra);

        return new RedirectView("/porra/" + p.getId());
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
