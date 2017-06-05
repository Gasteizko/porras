package es.ucm.fdi.porras.controller;

import java.security.Principal;
import java.util.List;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.repository.PorraRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller	
public class RootController {

	@Autowired
	PorraRepository porraRepository;

	private static Logger log = Logger.getLogger(RootController.class);
	
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "/static");
    }

	@GetMapping({"/"})
	public String root(Model model, Principal principal) {
		List<Porra> porrasIndex = porraRepository.findAll();
		model.addAttribute("porrasIndex", porrasIndex);
		return "index";
	}
/*
	@GetMapping("/login")
	public String login(){
		return "login";
	}*/

	@GetMapping("/dash")
	public String dash(){
    	return "dash";
	}

	@GetMapping("/listaporras")
	public String listaporras(){
		return "listaporras";
	}

	@GetMapping("/porra")
	public String porra(){
		return "porra";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
}
