package es.ucm.fdi.porras.utils;

import es.ucm.fdi.porras.model.dto.UserForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserForm user = (UserForm) obj;
        return user.getPassword().equals(user.getPasswordConfirmation());
    }
}
