package carpooling.model.journey.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Component
public class CreateStepFormValidator implements Validator{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateStepFormValidator.class);


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(CreateStepForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating {}", o);
        CreateStepForm form = (CreateStepForm) o;
    }
}
