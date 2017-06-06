package es.ucm.fdi.porras.model;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * An role (a security role) used by Spring Security.
 */
@Entity
@Table(name = "role")
@Access(AccessType.FIELD)
@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role implements Serializable {

    @NotNull
    @NonNull
    @Size(min = 0, max = 50)
    @Id
    @Column(length = 50)
    private String name;
}
