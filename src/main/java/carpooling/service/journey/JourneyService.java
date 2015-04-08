package carpooling.service.journey;

import carpooling.model.account.User;
import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.form.CreateJourneyForm;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface JourneyService {
    Journey createJourney(CreateJourneyForm form, User user);

    Optional<Journey> getJourneyById(long id);

    Collection<Journey> getAllJourneysByCities(List<City> cities) throws Exception;

}