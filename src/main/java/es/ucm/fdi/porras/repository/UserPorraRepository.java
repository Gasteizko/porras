package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPorraRepository extends JpaRepository<UserPorra, Long>{

    List<UserPorra> findAllByUser(@Param("user") User user);


    @Query("SELECT up FROM UserPorra up WHERE porra.id = :id_porra AND user.id = :id_user")
    public UserPorra findAllByIdPorra(@Param("id_porra") Long id_porra, @Param("id_user") Long id_user);

    /*    @Query("SELECT u FROM UserPorra WHERE user.id = :user_id AND winned = :winned")
    List<UserPorra> findAllByUserIdAndWinned(Long user, Boolean winned);*/

}
