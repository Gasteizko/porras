package es.ucm.fdi.porras.model.dto;

import es.ucm.fdi.porras.model.UserPorra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorraUsers implements Serializable {

    private String title;

    private String type;

    private List<UserPorra> users;
}
