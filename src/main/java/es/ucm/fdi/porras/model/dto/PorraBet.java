package es.ucm.fdi.porras.model.dto;

import es.ucm.fdi.porras.model.UserPorra;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PorraBet {

    private String login;
    private String bet;
    private Double betAmount;

}
