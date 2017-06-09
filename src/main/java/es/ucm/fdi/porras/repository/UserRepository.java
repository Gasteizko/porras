package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(final String email);

    User findByLogin(final String login);

    @Query("SELECT u FROM User u JOIN FETCH u.porras ps WHERE ps.porra.id = :porraId")
    List<User> findAllParticipantsByPorraId(@Param("porraId") Long porraId);

    @Query("SELECT u FROM User u JOIN FETCH u.porras ps WHERE ps.winned = 1 AND ps.porra.id = :porraId")
    List<User> findWinnerByPorraId(@Param("porraId") Long porraId);

}
