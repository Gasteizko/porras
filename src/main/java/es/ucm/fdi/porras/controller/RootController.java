package es.ucm.fdi.porras.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller	
public class RootController {

	private static Logger log = Logger.getLogger(RootController.class);
	
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("s", "/static");
    }

	@GetMapping({"/"})
	public String root(Model model, Principal principal) {
		//log.info(principal.getName() + " de tipo " + principal.getClass());
		// org.springframework.security.core.userdetails.User
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
