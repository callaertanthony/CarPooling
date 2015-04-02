package carpooling.service.journey;

import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.model.journey.form.CreateStepForm;
import carpooling.repository.JourneyRepository;
import carpooling.repository.StepRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.spi.CalendarNameProvider;

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
        LOGGER.debug("Journey creation with service");
        Journey journey = new Journey();
        Calendar calendar = Calendar.getInstance();
        LocalDate date;
        LocalTime time;

        for(CreateStepForm stepForm : form.getSteps()){
            //create step to populate
            Step step = new Step();

            //set date
            date = stepForm.getDate();
            time = stepForm.getTime();
            calendar.set(Calendar.YEAR, date.getYear());
            calendar.set(Calendar.MONTH, date.getMonth().getValue());
            calendar.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
            calendar.set(Calendar.HOUR_OF_DAY, time.getHour());
            calendar.set(Calendar.MINUTE, time.getMinute());
            step.setDateCalendar(calendar);

            //set city
            step.setCity(stepForm.getCity());
            LOGGER.debug("Add step={} in journey", step);

            //finaly, adding step to journey
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
