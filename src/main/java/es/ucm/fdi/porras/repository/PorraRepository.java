package es.ucm.fdi.porras.repository;


import es.ucm.fdi.porras.model.Porra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface PorraRepository extends JpaRepository<Porra, Long>{

    Porra findOneByTitle(String title);

    List<Porra> findAllByCreatorId(Long creatorId);

    List<Porra> findAllByOrderByCreatedTimeDesc();

    @Query("SELECT p FROM Porra p JOIN FETCH p.userPorras ps WHERE ps.user.id = :userId")
    Set<Porra> findAllByUserId( @Param("userId") Long userId);

    @Query("SELECT p FROM Porra p JOIN FETCH p.userPorras ps WHERE ps.winned = :winned AND ps.user.id = :userId")
    Set<Porra> findAllByUserIdAndWinned( @Param("userId") Long userId, @Param("winned") Boolean winned);

}
