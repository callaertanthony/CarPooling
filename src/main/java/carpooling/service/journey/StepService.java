package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.Step;

import java.util.Collection;

/**
 * Created by anthonycallaert on 02/04/15.
 */
public interface StepService {
    Collection<Step> getAllStepsByCities(Collection<City> cities);
}
