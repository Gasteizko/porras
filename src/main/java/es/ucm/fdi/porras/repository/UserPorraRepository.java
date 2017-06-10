package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.UserPorra;
import es.ucm.fdi.porras.model.compID.UserPorraCompId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPorraRepository extends JpaRepository<UserPorra, UserPorraCompId> {
}
