package es.ucm.fdi.porras.service;


import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.Role;
import es.ucm.fdi.porras.model.RolesConstants;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.dto.PorraForm;
import es.ucm.fdi.porras.model.dto.UserForm;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.utils.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("porraService")
@Transactional
@Slf4j
public class PorraService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PorraRepository porraRepository;

    public PorraService(UserRepository userRepository, PorraRepository porraRepository) {
        this.userRepository = userRepository;
        this.porraRepository = porraRepository;
    }

    public Optional<Porra> getPorraByName(String name){
        log.debug("Getting porra by name {}", name);
        return porraRepository.findOneByName(name);

    }

    public Porra registerNewPorra(PorraForm porraForm) throws UserAlreadyExistException {

        final Porra porra = new Porra();
        porra.setName(porraForm.getTituloPorra());
        porra.setFinishTime(new Date(1000000));
        porra.setCreator(null);
        porra.setType("MATCH");
        porraRepository.save(porra);
        return porra;
    }

}
