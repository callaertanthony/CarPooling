package carpooling.model.journey.form;

import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Component
public class CreateJourneyFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateJourneyFormValidator.class);
    private final CreateStepFormValidator createStepFormValidator;

    @Autowired
    public CreateJourneyFormValidator(CreateStepFormValidator createStepFormValidator) {
        this.createStepFormValidator = createStepFormValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(CreateJourneyForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating {}", o);
        CreateJourneyForm form = (CreateJourneyForm) o;
        validateSteps(errors, form);
        //TODO verify steps order
        int idx = 0;
        for(CreateStepForm stepForm : form.getSteps()){
            errors.pushNestedPath("steps[" + idx + "]");
            ValidationUtils.invokeValidator(createStepFormValidator, stepForm, errors);
            errors.popNestedPath();
            idx++;
        }
    }

    public void validateSteps(Errors errors, CreateJourneyForm form){
        if(form.getSteps().size() < 2){
            errors.reject("journey.stepCount", "You need at least two steps : Start and Finish");
        }
    }
}
