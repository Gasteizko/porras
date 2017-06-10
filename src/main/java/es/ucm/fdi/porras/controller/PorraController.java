package es.ucm.fdi.porras.controller;

import es.ucm.fdi.porras.model.*;
import es.ucm.fdi.porras.model.compID.UserPorraCompId;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.PossibleBetRepository;
import es.ucm.fdi.porras.repository.UserPorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.service.PorraService;
import es.ucm.fdi.porras.service.UserService;
import es.ucm.fdi.porras.storage.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Slf4j
public class PorraController {

    private PorraService porraService;

    private UserService userService;

    private UserRepository userRepository;

    private PorraRepository porraRepository;

    private UserPorraRepository userPorraRepository;

    private PossibleBetRepository possibleBetRepository;

    private final StorageService storageService;

    private PasswordEncoder passwordEncoder;


    public PorraController(PorraService porraService, UserService userService, UserRepository userRepository,
                           PorraRepository porraRepository, StorageService storageService, UserPorraRepository userPorraRepository, PasswordEncoder passwordEncoder,  PossibleBetRepository possibleBetRepository) {
        this.porraService = porraService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.porraRepository = porraRepository;
        this.userPorraRepository = userPorraRepository;
        this.storageService = storageService;
        this.passwordEncoder = passwordEncoder;
        this.possibleBetRepository = possibleBetRepository;

    }

    @RequestMapping(value = {"/porra"}, method = RequestMethod.GET)
    public RedirectView getPorra(Principal principal, Model model) {

        // If try to access /porra without the id redirect to dash
        return new RedirectView("/dash");
    }

    @RequestMapping(value = {"/porra/{id}"}, method = RequestMethod.GET)
    public String getPorraById(@PathVariable("id") Long id, Principal principal, Model model) {
        if (id == null ) {
            log.warn("Null id");
            return "porra";
        }
        Porra p = porraRepository.findOne(id);

        if (p == null) {
            log.error("No such porra: {}", id);
        } else {
            model.addAttribute("p", p);
            model.addAttribute("principal", principal);
        }
        if(p.getPossibleBets().size() > 0){
        	model.addAttribute("possibleBet", p.getPossibleBets());
        }

        return "porra";
    }

    @RequestMapping(value = "/asignarGanador/{id}", method = RequestMethod.POST)
    public RedirectView insertNewPorra(@PathVariable("id") Long id,
                                       @RequestParam(value="login", required=true) String login,
                                       @RequestParam(value="action", required=true) String action) {

      Porra p = porraRepository.findOne(id);
      if (action.equals("asignar")) {
          p.setWinerBet(login);
      } else if (action.equals("eliminar")) {
        p.setWinerBet("null");
      }
      porraRepository.save(p);

      String url = "/porra/" + id;
      return new RedirectView(url);
    }

    @RequestMapping(value = "/eliminarPorra/{id}", method = RequestMethod.POST)
    public RedirectView insertNewPorra(@PathVariable("id") Long id) {

        porraRepository.delete(id);

        return new RedirectView("/dash");
    }

    @RequestMapping(value = "/betPorra/{id}", method = RequestMethod.POST)
    public RedirectView insertNewPorra(@PathVariable("id") Long id,
                                       @RequestParam(value="betstring",   required=false) String bet,
                                       @RequestParam(value="betamount",   required=false) String amount,
                                       @RequestParam(value="possibleBet", required=false) String possible,
                                       Model model, Principal principal) {

        bet = possible;
        if (!bet.isEmpty() && !amount.isEmpty()) {
            UserPorra up = new UserPorra();
            up.setBet(bet);
            up.setBetAmount(Double.parseDouble(amount));
            User user = userRepository.findByLogin(principal.getName());
            up.setUser(user);
            Porra porra = porraRepository.findOneById(id);
            up.setPorra(porra);
            Set<PossibleBet> pb = possibleBetRepository.findAllByPorraId(id);
            PossibleBet aux = null;
            for (Iterator<PossibleBet> it = pb.iterator(); it.hasNext(); ) {
              aux = it.next();
            }
            up.setPossibleBet(aux);
            UserPorraCompId userPorraCompId = new UserPorraCompId(user.getId(), porra.getId());
            up.setUserPorraCompId(userPorraCompId);
            userPorraRepository.save(up);
        } else  {
            log.error("No valid data: {}", id);
        }

        String url = "/porra/" + id;
        return new RedirectView(url);
    }

    @RequestMapping(value = "/newPorra", method = RequestMethod.GET)
    public String showNewPorraForm(Model model) {
        PorraForm porraForm = new PorraForm();
        model.addAttribute("porra", porraForm);
        return "newPorra";
    }

    @RequestMapping(value = "/newPorration", method = RequestMethod.POST)
    public RedirectView newPorrita(@ModelAttribute("porraForm") @Valid PorraForm porraForm,
                                   BindingResult result, final Errors errors, Principal principal) {
        if (result.hasErrors()) {
            log.warn("New Porra error:",  errors.getAllErrors().toString());
            return new RedirectView("/newPorra?error");
        }
        log.info("Registering new porra: {}", porraForm);
        String nameUser = principal.getName();
        User currentUser = userRepository.findByLogin(nameUser);
        Porra createdPorra = new Porra();
        createdPorra.setTitle(porraForm.getTituloPorra());
        createdPorra.setCreator(currentUser);
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = porraForm.getFinishTime();
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }

        log.info(fecha.toString());
        createdPorra.setType(porraForm.getTipoPorra());
        createdPorra.setFinishTime(fecha);
        createdPorra.setDescription(porraForm.getDescripcionPorra());
        createdPorra.setEquipoLocal(porraForm.getEquipoLocal());
        createdPorra.setEquipoVisitante(porraForm.getEquipoVisitante());
        createdPorra.setTipoApuesta(porraForm.getTipoApuesta());
        createdPorra.setMinBet(porraForm.getMinBet());
        createdPorra.setApuestaOpen(porraForm.getApuestaOpen());
        //createdPorra.setContrasenya(porraForm.getContrasenya());
        createdPorra.setContrasenya(passwordEncoder.encode(porraForm.getContrasenya()));
        if(! porraForm.getFile().isEmpty()) {
            storageService.store(porraForm.getFile(), porraForm.getTituloPorra() + ".jpg");
            createdPorra.setImageUrl(porraForm.getTituloPorra() + ".jpg");

        }
        if(porraForm.getTipoPorra().equals("POSSIBLES")){
        	List<PossibleBet> lpb = new ArrayList<PossibleBet>();
        	String tosplit = porraForm.getPosiblesResultados();
        	String[] resultados = tosplit.split(";");
        	for(int i = 0; i < resultados.length; i++){
        		PossibleBet p = new PossibleBet();
        		p.setBet(resultados[i]);
        		p.setPorra(createdPorra);
        		lpb.add(p);
        	}
        	createdPorra.setPossibleBets(lpb);
        }
        Porra p = porraRepository.save(createdPorra);
    	  possibleBetRepository.save(p.getPossibleBets());
        /*for(int i = 0; i < p.getPossibleBets().size(); i++){
        	PossibleBet pb = p.getPossibleBets().get(i);
        	possibleBetRepository.
        }*/
        return new RedirectView("/porra/" + p.getId());
    }

    @GetMapping(value = "/listaporras")
    public String listaporras(
            @RequestParam(value = "latest", required = false) Boolean latest,
            @RequestParam(value = "winned", required = false) Boolean winned,
            @RequestParam(value = "losses", required = false) Boolean losses,
            @RequestParam(value = "mine", required = false) Boolean mine,
            @RequestParam(value = "playing", required = false) Boolean playing,
            Principal principal, Model model) {

        User currentUser = userRepository.findByLogin(principal.getName());

        Collection<Porra> porras = null;
        if (latest != null){
            log.info("Getting latest porras");
            porras = porraRepository.findAllByOrderByCreatedTimeDesc();
            int numporras = porras.size();
            model.addAttribute("numporras", numporras);
        }
        else if (winned != null) {
            log.info("Getting winned porras");
            porras = porraRepository.findAllByUserIdAndWinned(currentUser.getId(), true);
            int numporrasW = porras.size();
            model.addAttribute("numporrasW", numporrasW);
        }
        else if (losses != null){
            log.info("Getting losses porras");
            porras = porraRepository.findAllByUserIdAndWinned(currentUser.getId(), false);
            int numporrasL = porras.size();
            model.addAttribute("numporrasL", numporrasL);
        }
        else if (mine != null) {
            log.info("Getting mine porras");
            porras = porraRepository.findAllByCreatorId(currentUser.getId());
            int numporrasM = porras.size();
            model.addAttribute("numporrasM", numporrasM);
        }
        else if (playing != null) {
          log.info("Getting playing porras");
          porras = porraRepository.findAllByUserId(currentUser.getId());
          int numporrasP = porras.size();
          model.addAttribute("numporrasP", numporrasP);
        }
        else {
            porras = porraRepository.findAll();
        }
        model.addAttribute("porras", porras);

        return "listaporras";
    }

}
