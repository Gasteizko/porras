package es.ucm.fdi.porras.model.dto;

import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.utils.PasswordMatches;
import es.ucm.fdi.porras.utils.ValidEmail;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PorraForm {

    @NotNull
    @Size(min=3, max=100)
    @NotBlank
    private String tituloPorra;

    @NotNull
    @NotBlank
    private Date finishTime;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    private User creator;

}