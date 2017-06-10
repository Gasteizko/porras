package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.UserFriend;
import es.ucm.fdi.porras.model.compID.UserFriendCompId;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.model.dto.UserForm;
import es.ucm.fdi.porras.repository.UserFriendRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.storage.StorageService;
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
import java.math.BigInteger;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.List;

@Controller
@Slf4j
public class UserController {

	private UserService userService;

	private UserRepository userRepository;

  private final StorageService storageService;

  private final UserFriendRepository userFriendRepository;

	public UserController (UserService userService, UserRepository userRepository, StorageService storageService,
                         UserFriendRepository userFriendRepository) {
	    this.userService = userService;
	    this.userRepository = userRepository;
	    this.storageService = storageService;
	    this.userFriendRepository = userFriendRepository;
    }

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
  @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
  public String getUserProfileByUserId(Model model){
	  return "redirect:/dash";
  }

  @RequestMapping(value = {"/user/{login}"}, method = RequestMethod.GET)
  public String getUserProfileByUserId(@PathVariable("login") String login, Principal principal, Model model) {
    User u = userRepository.findByLogin(login);
    User currentUser = userRepository.findByLogin(principal.getName());
    List<UserFriend> friends = currentUser.getFriends();
    Boolean friend = false;
    for (UserFriend f : friends ){
      if (f.getUser().equals(u)){
        friend = true;
        break;
      }
    }
    if ( login.isEmpty() || u == null)
      return "redirect:/dash";
	  model.addAttribute("user", u);
    model.addAttribute("friend", friend);
	  return "user";
  }

  @GetMapping("/profile")
  public String profile(Model model, Principal principal) {
    String name = principal.getName();
    User user = userRepository.findByLogin(name);
    model.addAttribute("user", user);
    return "profile";
  }

  @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
  public RedirectView newPorrita(@ModelAttribute("porraForm") UserForm userForm,
                                 BindingResult result, final Errors errors, Principal principal) {
    User u = userRepository.findByLogin(principal.getName());
    if(! userForm.getProfileImage().isEmpty() && u != null) {
      String mime = userForm.getProfileImage().getContentType();
      // Only allows upload png and jpg images
      if (mime.equals("image/png") || mime.equals("image/jpg")){
        String randString = new BigInteger(130, new SecureRandom()).toString(32);
        String extension = mime.split("/")[1];
        String fileName = randString + u.getLogin() + "." + extension;
        storageService.store(userForm.getProfileImage(), fileName);
        u.setImageUrl(fileName);
        userRepository.save(u);
      }
    }
    return new RedirectView("/profile");
  }

  @RequestMapping(value = "/friendRequest", method = RequestMethod.POST)
  public RedirectView friendRequest( @RequestParam(value = "login", required = true) String login, Principal principal) {
    User newFriend = userRepository.findByLogin(login);
    User currentUser = userRepository.findByLogin(principal.getName());
    if (newFriend == null || currentUser == null){
      return new RedirectView("/user/" + login + "?error");
    }
    UserFriend newAmistad = new UserFriend();
    newAmistad.setRequest(true);
    newAmistad.setActive(false);
    newAmistad.setUser(currentUser);
    newAmistad.setFriend(newFriend);
    newAmistad.setUserFriendCompId(new UserFriendCompId(currentUser.getId(), newFriend.getId()));
    userFriendRepository.save(newAmistad);
    List<UserFriend> friends = currentUser.getFriends();
    friends.add(newAmistad);
    currentUser.setFriends(friends);
    userRepository.save(currentUser);
    return new RedirectView("/user/" + login);

  }
}
