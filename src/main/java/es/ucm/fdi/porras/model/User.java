package es.ucm.fdi.porras.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.Instant;

/**
 * A user.
 */
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
@Access(AccessType.FIELD)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"userFriends", "porras"})
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, unique = true, nullable = false)
    @NonNull
    private String login;

    @Size(max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    @NonNull
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    @Column(length = 100, unique = true, nullable = false)
    @NonNull
    private String email;

    @JsonIgnore
    @NotNull
    @NonNull
    @Size(min = 60, max = 255)
    @Column(name = "password_hash",length = 255)
    private String password;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserPorra> porras;

    @NotNull
    @NonNull
    @Column(nullable = false)
    private boolean activated = false;

    @Column(name = "last_login_time", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Column(name = "created_time", updatable = false, insertable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdTime;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")})
    @NonNull
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "friend", fetch = FetchType.LAZY)
    private List<UserFriend> userFriends;

}
