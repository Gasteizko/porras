package es.ucm.fdi.porras.utils.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Throwable {

    public UserAlreadyExistException(final String message) {
        super(message);
    }

}