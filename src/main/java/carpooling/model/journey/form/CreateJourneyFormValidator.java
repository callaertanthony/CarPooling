package carpooling.model.journey.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateJourneyFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateJourneyFormValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(CreateJourneyForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating {}", o);
        CreateJourneyForm form = (CreateJourneyForm) o;
    }
}
