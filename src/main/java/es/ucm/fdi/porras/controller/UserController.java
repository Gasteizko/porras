package es.ucm.fdi.porras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.ucm.fdi.porras.service.UserService;
import es.ucm.fdi.porras.model.User;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registro";
    }

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public RedirectView registro(@ModelAttribute("userForm") User user) {
        userService.saveUser(user);

        return new RedirectView("/");
	}
}
