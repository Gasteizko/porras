package es.ucm.fdi.porras.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.UserPorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.service.UserPorraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class RootController {

	PorraRepository porraRepository;
	UserRepository userRepository;
	UserPorraRepository userporraRepository;
	UserPorraService userporraService;

	public RootController (PorraRepository porraRepository, UserRepository userRepository, UserPorraRepository userporraRepository, UserPorraService userporraService) {
		this.porraRepository = porraRepository;
		this.userRepository = userRepository;
		this.userporraRepository = userporraRepository;
		this.userporraService = userporraService;
	}

	@GetMapping({"/"})
	public String root(Model model, Principal principal) {
		List<Porra> porrasIndex = porraRepository.findAll();
		model.addAttribute("porrasIndex", porrasIndex);
		return "index";
	}

	@GetMapping("/dash")
	public String dash(Model model, Principal principal) {
		String name = principal.getName();
		User u = userRepository.findByLogin(name);
		//porras m�s recientes
		List<Porra> porrasRecent = porraRepository.findAllByOrderByCreatedTimeDesc();
		List<Porra> pr = new ArrayList<Porra>();
		model.addAttribute("porrasRecent", porrasRecent);
		//porras a las que pertenece el usuario 
		List<Porra> porrasUser = userporraService.porrasbyUsuario(u);
		model.addAttribute("porrasUser", porrasUser);
		//porras ganas por el usuario
		Set<Porra> porrasUserWin = porraRepository.findAllByUserIdAndWinned(u.getId(), true);
		model.addAttribute("porrasUserWin", porrasUserWin);
		//porras ganas por el usuario
		Set<Porra> porrasUserLost = porraRepository.findAllByUserIdAndWinned(u.getId(), false);
		model.addAttribute("porrasUserLost", porrasUserLost);
		//porras creadas por el usuario
		List<Porra> porrasCreator = porraRepository.findAllByCreatorId(u.getId());
		model.addAttribute("porrasCreator", porrasCreator);
    	return "dash";
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
