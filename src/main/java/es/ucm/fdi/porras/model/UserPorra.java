package es.ucm.fdi.porras.model;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_porra")
@Access(AccessType.FIELD)
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserPorra implements Serializable {

    @EmbeddedId
    private UserPorraId userPorraId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "porra_id", nullable = false, updatable = false, insertable = false)
    @NonNull
    private Porra porra;

    @Column(length = 255)
    private String bet;

    @Column
    private Boolean winned;

    @Column(length = 255)
    private Boolean paid;

    @Column(name = "paid_time")
    private Date paidTime;

    @OneToOne
    private PossibleBet possibleBet;

    @Column(name="bet_amount")
    private Double betAmount;

}
