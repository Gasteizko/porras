package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.model.dto.UserForm;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.service.PorraService;
import es.ucm.fdi.porras.utils.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@Slf4j
public class PorraController {

    private PorraService porraService;

    public PorraController (PorraService porraService) {
        this.porraService = porraService;
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

    @GetMapping(value = "/listaporras",
            params = {"_search", "nd", "rows", "page", "sidx", "sort"})
    public String listaporras (
            @RequestParam(value = "_search") String search,
            @RequestParam(value = "nd") int nd,
            @RequestParam(value = "rows") int rows,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "sidx") int sidx,
            @RequestParam(value = "sort") Sort sort) {

        return "listaporras";
    }

}
