package es.ucm.fdi.porras.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="possible_bet")
@Access(AccessType.FIELD)
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PossibleBet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(length = 255)
    @NonNull
    private String bet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_porra", nullable = false)
    @NonNull
    private Porra porra;
}
