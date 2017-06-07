package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.service.PorraService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PorraController {

    PorraRepository porraRepository;

    PorraService porraService;

    @GetMapping({"/porra"})
    public String getPorra() {
        return "porra";
    }


    @GetMapping({"/newPorra"})
    public String newPorraForm() {
        return "newPorra";
    }


    @GetMapping("/listaporras")
    public String listaporras(){
        return "listaporras";
    }

}
