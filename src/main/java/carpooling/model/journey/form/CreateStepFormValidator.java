package carpooling.model.journey.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

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
        validateDateTime(errors, form);
    }

    private void validateDateTime(Errors errors, CreateStepForm form){
        LOGGER.debug("Validating date for step={}", form);
        Calendar actualCalendar = Calendar.getInstance();
        Calendar formCalendar = Calendar.getInstance();
        LocalDate date = form.getDate();
        LocalTime time = form.getTime();

        //set form date
        formCalendar.set(Calendar.YEAR, date.getYear());
        formCalendar.set(Calendar.MONTH, date.getMonth().getValue());
        formCalendar.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
        formCalendar.set(Calendar.HOUR_OF_DAY, time.getHour());
        formCalendar.set(Calendar.MINUTE, time.getMinute());

        //compare calendars
        if(formCalendar.before(actualCalendar)){
            errors.reject("date.passed", "The date has passed");
        }
    }
}
