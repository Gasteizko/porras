package es.ucm.fdi.porras.repository;

import es.ucm.fdi.porras.model.PossibleBet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PossibleBetRepository extends JpaRepository<PossibleBet, Long> {

    @Query("SELECT pb FROM PossibleBet pb WHERE pb.porra.id = :porraId")
    Set<PossibleBet> findAllByPorraId( @Param("porraId") Long porraId);

    @Query("SELECT pb FROM PossibleBet pb JOIN pb.porra.userPorras up WHERE up.user.id = :userId AND pb.porra.id = :porraId")
    Set<PossibleBet> findAllByPorraIdAndUserId( @Param("porraId") Long porraId, @Param("userId") Long userId);

}
