package es.ucm.fdi.porras.model.dto;

import es.ucm.fdi.porras.utils.PasswordMatches;
import es.ucm.fdi.porras.utils.ValidEmail;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@PasswordMatches
public class UserForm {

    @NotNull
    @Size(min=3, max=100)
    @NotBlank
    private String login;

    @NotNull
    @Size(min=3, max=50)
    @NotBlank
    private String firstName;

    private String lastName;

    @NotNull
    @Size(min=5, max=100)
    @NotBlank
    @ValidEmail
    private String email;
     
    @NotNull
    @Size(min=3, max=255)
    @NotBlank
    private String password;

    @NotNull
    @Size(min=3, max=255)
    @NotBlank
    private String passwordConfirmation;

}