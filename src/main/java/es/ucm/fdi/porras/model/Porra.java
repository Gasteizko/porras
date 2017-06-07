package es.ucm.fdi.porras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="porra")
@Access(AccessType.FIELD)
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"possibleBets"})
@EqualsAndHashCode
public class Porra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NotNull
    @NonNull
    @Column(name="external_id", length = 255, nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false, length = 255)
    @NonNull
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

    @Column(name = "finish_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date finishTime;

    @Column(name = "type", nullable = false)
    @NonNull
    private String type;

    @Column(name = "visits")
    private Long visits;

    @OneToMany(mappedBy = "porra", fetch = FetchType.LAZY)
    private List<PossibleBet> possibleBets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", nullable = false, updatable = false)
    @NonNull
    private User creator;

}
