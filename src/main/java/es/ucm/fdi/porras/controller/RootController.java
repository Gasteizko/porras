package es.ucm.fdi.porras.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import es.ucm.fdi.porras.repository.PorraRepository;
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

	private PorraRepository porraRepository;
	private UserRepository userRepository;
	private UserPorraService userporraService;

	public RootController (PorraRepository porraRepository, UserRepository userRepository, UserPorraService userporraService) {
		this.porraRepository = porraRepository;
		this.userRepository = userRepository;
		this.userporraService = userporraService;
	}

	@GetMapping({"/"})
	public String root(Model model, Principal principal) {
	  // Si ya está logueado el usuario se le redirige al dash
	  if (principal != null && ! principal.getName().isEmpty())
	    return "redirect:/dash";
		List<Porra> porrasIndex = porraRepository.findTop10ByOrderByCreatedTimeDesc();
		model.addAttribute("porrasIndex", porrasIndex);
		return "index";
	}

	@GetMapping("/dash")
	public String dash(Model model, Principal principal) {
		String name = principal.getName();
		User u = userRepository.findByLogin(name);
		//porras más recientes
		List<Porra> porrasRecent = porraRepository.findAllByOrderByCreatedTimeDesc();
		List<Porra> pr = new ArrayList<Porra>();
		model.addAttribute("porrasRecent", porrasRecent);
		int numporrasRecent = porrasRecent.size();
		model.addAttribute("numporrasRecent", numporrasRecent);
		//porras a las que pertenece el usuario
		Collection<Porra> porrasUser = null;
		porrasUser = porraRepository.findAllByUserId(u.getId());
		model.addAttribute("porrasUser", porrasUser);
		int numporrasUser = porrasUser.size();
		model.addAttribute("numporrasUser", numporrasUser);
		//porras ganas por el usuario
		Set<Porra> porrasUserWin = porraRepository.findAllByUserIdAndWinned(u.getId(), true);
		model.addAttribute("porrasUserWin", porrasUserWin);
		int numporrasUserWin = porrasUserWin.size();
		model.addAttribute("numporrasUserWin", numporrasUserWin);
		//porras ganas por el usuario
		Set<Porra> porrasUserLost = porraRepository.findAllByUserIdAndWinned(u.getId(), false);
		model.addAttribute("porrasUserLost", porrasUserLost);
		int numporrasUserLost = porrasUserLost.size();
		model.addAttribute("numporrasUserLost", numporrasUserLost);
		//porras creadas por el usuario
		List<Porra> porrasCreator = porraRepository.findAllByCreatorId(u.getId());
		model.addAttribute("porrasCreator", porrasCreator);
		int numporrasCreator = porrasCreator.size();
		model.addAttribute("numporrasCreator", numporrasCreator);
    	return "dash";
	}

	@GetMapping("/profile")
	public String profile(Model model, Principal principal) {
		String name = principal.getName();
		User user = userRepository.findByLogin(name);
		model.addAttribute("user", user);
		return "profile";
	}

}
