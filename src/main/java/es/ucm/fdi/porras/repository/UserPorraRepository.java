package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPorraRepository extends JpaRepository<UserPorra, Long>{

    List<UserPorra> findAllByUser(@Param("user") User user);

    /*    @Query("SELECT u FROM UserPorra WHERE user.id = :user_id AND winned = :winned")
    List<UserPorra> findAllByUserIdAndWinned(Long user, Boolean winned);*/

}
