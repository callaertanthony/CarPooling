package carpooling.model.journey.form;

import carpooling.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by Guillaume on 06/04/2015.
 */
@Component
public class SearchJourneyFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchJourneyFormValidator.class);

    private final CityRepository cityRepository;

    @Autowired
    public SearchJourneyFormValidator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SearchJourneyForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LOGGER.debug("Validating {}", o);
        SearchJourneyForm form = (SearchJourneyForm) o;
        validateDeparture(errors, form);
        validateArrival(errors, form);
    }

    private void validateDeparture(Errors errors, SearchJourneyForm form){
        if(null != cityRepository.findByNameIgnoreCaseIn(form.getDeparture())){
            errors.reject("city.no_exist", "The departure city doesn't exist in database");
        }
    }

    private void validateArrival(Errors errors, SearchJourneyForm form){
        if(null != cityRepository.findByNameIgnoreCaseIn(form.getArrival())){
            errors.reject("city.no_exist", "The arrival city doesn't exist in database");
        }
    }
}
