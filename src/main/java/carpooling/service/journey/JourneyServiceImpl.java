package carpooling.service.journey;

import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.repository.JourneyRepository;
import carpooling.repository.StepRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JourneyServiceImpl.class);
    private final JourneyRepository journeyRepository;
    private final StepRepository stepRepository;

    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository, StepRepository stepRepository) {
        this.journeyRepository = journeyRepository;
        this.stepRepository = stepRepository;
    }

    @Override
    public Journey createJourney(CreateJourneyForm form) {
        Journey journey = new Journey();
        for(Step s : form.getSteps()){
            Step step = new Step();
            step.setCity(s.getCity());
            journey.addStep(step);
        }
        return journeyRepository.save(journey);
    }

    @Override
    public Optional<Journey> getJourneyById(long id) {
        LOGGER.debug("Getting journey={}", id);
        return Optional.ofNullable(journeyRepository.findOne(id));
    }
}
