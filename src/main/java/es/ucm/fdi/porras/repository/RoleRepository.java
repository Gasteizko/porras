package es.ucm.fdi.porras.repository;


import es.ucm.fdi.porras.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
