package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPorraRepository extends JpaRepository<UserPorra, Long> {

    List<UserPorra> findAllByUser(@Param("user") User user);
}
