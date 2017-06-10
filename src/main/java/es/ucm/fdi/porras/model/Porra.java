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
@ToString(exclude = {"possibleBets", "participants"})
@EqualsAndHashCode
public class Porra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(name = "title", nullable = false, length = 255, unique = true)
    @NonNull
    private String title;

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

    @Column(name = "created_time", nullable = false, updatable = false, insertable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date createdTime;

    @Column(name = "finish_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date finishTime;

    @Column(name = "type", nullable = false)
    @NonNull
    private String type;

    @Column(name = "visits")
    private Long visits;

    @Column(name = "equipoLocal")
    private String equipoLocal;

    @Column(name = "equipoVisitante")
    private String equipoVisitante;

    @Column(name = "min_bet")
    private Double minBet;

    @Column(name = "tipoApuesta")
    private String tipoApuesta;

    @Column(name = "apuestaOpen")
    private String apuestaOpen;

    @Column(name = "contrasenya")
    private String contrasenya;

    @OneToMany(mappedBy = "porra", fetch = FetchType.LAZY)
    private List<UserPorra> participants;

    @OneToMany(mappedBy = "porra", fetch = FetchType.LAZY)
    private List<PossibleBet> possibleBets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", nullable = false, updatable = false)
    @NonNull
    private User creator;


}
