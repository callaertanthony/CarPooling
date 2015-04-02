package carpooling.service.journey;

import carpooling.model.account.User;
import carpooling.model.journey.Journey;
import carpooling.model.journey.form.CreateJourneyForm;

import java.util.Optional;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface JourneyService {
    Journey createJourney(CreateJourneyForm form, User user);

    Optional<Journey> getJourneyById(long id);
}
