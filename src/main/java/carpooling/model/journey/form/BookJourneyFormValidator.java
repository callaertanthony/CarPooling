package carpooling.model.journey.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by anthonycallaert on 09/04/15.
 */
@Component
public class BookJourneyFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookJourneyFormValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(BookJourneyForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating book {}", o);
        BookJourneyForm bookJourneyForm = (BookJourneyForm) o;
    }
}
