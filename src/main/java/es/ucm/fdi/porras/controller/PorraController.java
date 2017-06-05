package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.service.PorraService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/porra")
public class PorraController {

    PorraRepository porraRepository;

    PorraService porraService;

    @GetMapping({"/"})
    public String getPorra() {
        return "porra";
    }
}
