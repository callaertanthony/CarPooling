package carpooling.model.account.form;

import carpooling.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by anthonycallaert on 27/03/15.
 */
@Component
public class CreateAccountFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountFormValidator.class);
    private final UserService userService;

    @Autowired
    public CreateAccountFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(CreateAccountForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating {}", o);
        CreateAccountForm form = (CreateAccountForm) o;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, CreateAccountForm form){
        if(!form.getPassword().equals(form.getPasswordRepeated())){
            errors.reject("password.no_match", "Password don't match");
        }
    }

    private void validateEmail(Errors errors, CreateAccountForm form){
        if(userService.getUserByEmail(form.getEmail()).isPresent()){
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
