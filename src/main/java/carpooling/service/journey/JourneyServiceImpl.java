package carpooling.service.journey;

import carpooling.model.journey.Journey;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.repository.JourneyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class JourneyServiceImpl implements JourneyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JourneyServiceImpl.class);
    private final JourneyRepository journeyRepository;

    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Override
    public Journey createJourney(CreateJourneyForm form) {
        Journey journey = new Journey();
        journey.setSteps(form.getSteps());
        return journey;
    }

    @Override
    public Optional<Journey> getJourneyById(long id) {
        LOGGER.debug("Getting journey={}", id);
        return Optional.ofNullable(journeyRepository.findOne(id));
    }
}
