package es.ucm.fdi.porras.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_porra")
@Data
@Accessors(chain = true)
@Access(AccessType.FIELD)
@EqualsAndHashCode(of = "id")
public class UserPorra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String bet;

    @Column()
    private Boolean winned;

    @Column(length = 255)
    private Boolean paid;

    @Column(name = "paid_time")
    private Date paidTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false, updatable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_porra", nullable = false, updatable = false)
    private Porra porra;

}
