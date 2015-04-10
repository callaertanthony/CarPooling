package carpooling.service.journey;

import carpooling.model.account.User;
import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateStepForm;

import java.util.Collection;
import java.util.Set;

/**
 * Created by anthonycallaert on 02/04/15.
 */
public interface StepService {
    Collection<Step> getAllStepsByCities(Collection<City> cities);

    Step createStep(CreateStepForm stepForm);

    Set<Step> getAllStepsByUser(User user);
}
