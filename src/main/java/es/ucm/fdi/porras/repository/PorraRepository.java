package es.ucm.fdi.porras.repository;


import es.ucm.fdi.porras.model.Porra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PorraRepository extends JpaRepository<Porra, Long>{

    @Query("SELECT p FROM Porra p WHERE p.name = :name")
    Optional<Porra> findOneByName(@Param("name") String name);
}
