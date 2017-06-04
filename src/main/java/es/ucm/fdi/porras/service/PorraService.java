package es.ucm.fdi.porras.service;


import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.repository.PorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PorraService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final PorraRepository porraRepository;

    public PorraService(UserRepository userRepository, PorraRepository porraRepository) {
        this.userRepository = userRepository;
        this.porraRepository = porraRepository;
    }

    public Optional<Porra> getPorraByName(String name){
        log.debug("Getting porra by name {}", name);
        return porraRepository.findOneByName(name);

    }


}
