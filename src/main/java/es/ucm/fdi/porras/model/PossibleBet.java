package es.ucm.fdi.porras.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="possible_bet")
public class PossibleBet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String bet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_porra", nullable = false)
    private Porra porra;
}
