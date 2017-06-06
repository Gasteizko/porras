package es.ucm.fdi.porras.controller;

import java.security.Principal;
import java.util.List;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.repository.PorraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class RootController {

	@Autowired
	PorraRepository porraRepository;

	@GetMapping({"/"})
	public String root(Model model, Principal principal) {
		List<Porra> porrasIndex = porraRepository.findAll();
		model.addAttribute("porrasIndex", porrasIndex);
		return "index";
	}

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
