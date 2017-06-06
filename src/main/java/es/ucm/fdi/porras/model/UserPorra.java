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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(length = 255)
    private String bet;

    @Column()
    private Boolean winned;

    @Column(length = 255)
    private Boolean paid;

    @Column(name = "paid_time")
    private Date paidTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false, updatable = false)
    @NonNull
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_porra", nullable = false, updatable = false)
    @NonNull
    private Porra porra;

}
