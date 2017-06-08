package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.PossibleBet;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
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

import javax.validation.Valid;
import java.security.Principal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @GetMapping({"/porra"})
    public String getPorra() {
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
                                   BindingResult result, final Errors errors) {
        /*if (result.hasErrors()) {
            log.warn("New Porra error:",  errors.getAllErrors().toString());
            return new RedirectView("/newPorra?newPorraError");
        }*/
        //log.info("Registering new porra: {}", porraForm);
        Porra registered = null;
        try {
            registered = porraService.registerNewPorra(porraForm);
        } catch (UserAlreadyExistException e) {
            //log.warn("Registration error:",  e);
        }
        /*if (registered == null) {
            return new RedirectView("/newPorra?newPorraError");
        }*/

        //log.info("New Porra registration: {}", porraForm);

        return new RedirectView("/dash");
    }

    @GetMapping(value = "/listaporras")
    public String listaporras(
            @RequestParam(value = "latest", required = false) Boolean latest,
            @RequestParam(value = "winned", required = false) Boolean winned,
            @RequestParam(value = "losses", required = false) Boolean losses,
            @RequestParam(value = "mine", required = false) Boolean mine, Principal principal, Model model) {

        Set<PossibleBet> ps = possibleBetRepository.findAllByPorraIdAndUserId(6L, 3L);
        User currentUser = userRepository.findByLogin(principal.getName());
        List<User> participants = userRepository.findAllParticipantsByPorraId(5L);
        if (latest != null){
            log.info("Getting latest porras");
            List<Porra> latestPorras = porraRepository.findAllByOrderByCreatedTimeDesc();
        }
        else if (winned != null) {
            log.info("Getting winned porras");
            //List<UserPorra> userPorras = userPorraRepository.findAllByUserIdAndWinned(currentUser.getId(), true);
            //List<Porra> latestPorras = porraRepository.findAllByOrderByCreatedTimeDesc();
        }
        else if (losses != null){
            log.info("Getting losses porras");
            List<Porra> latestPorras = porraRepository.findAllByOrderByCreatedTimeDesc();
        }
        else if (mine != null) {
            log.info("Getting mines porras");

            List<Porra> latestPorras = porraRepository.findAllByCreatorId(currentUser.getId());
        }
        else {
            List<Porra> latestPorras = porraRepository.findAll();
        }

        return "listaporras";
    }

}
