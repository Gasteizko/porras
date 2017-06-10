package es.ucm.fdi.porras.model.dto;

import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.utils.PasswordMatches;
import es.ucm.fdi.porras.utils.ValidEmail;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

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
    private String finishTime;

    @NotNull
    @NotBlank
    private String descripcionPorra;

    @NotNull
    @NotBlank
    private String tipoPorra;

    private MultipartFile file;

    private String equipoLocal;

    private String equipoVisitante;

    private String tipoApuesta;

    private Double minBet;

    private String apuestaOpen;

    private String contrasenya;

}
