package es.ucm.fdi.porras.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="porra")
public class Porra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="external_id", length = 255, nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "winner_bet", length = 255)
    private String winerBet;

    @Column(name = "winner_possible_bet")
    private Integer winnerPosisibleBet;

    @Column(name = "max_participants")
    private Integer maxParticipantes;

    @Column(name = "finish_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<PossibleBet> possibleBets;


}
