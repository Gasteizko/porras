package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.dto.UserForm;
import es.ucm.fdi.porras.utils.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import es.ucm.fdi.porras.service.UserService;
import es.ucm.fdi.porras.model.User;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("user", userForm);
        return "registro";
    }

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public RedirectView registration(@ModelAttribute("userForm") @Valid UserForm userForm,
                                 BindingResult result, final Errors errors) {
        if (result.hasErrors()) {
            log.warn("Registration error:",  errors.getAllErrors().toString());
            return new RedirectView("/registro?registrationError");
        }
        log.info("Registering new user account: {}", userForm);
        User registered = null;
        try {
            registered = userService.registerNewUser(userForm);
        } catch (UserAlreadyExistException e) {
            log.warn("Registration error:",  e);
        }
        if (registered == null) {
            return new RedirectView("/registro?registrationError");
        }

        log.info("New User registration: {}", userForm);

        return new RedirectView("/");
	}
}
