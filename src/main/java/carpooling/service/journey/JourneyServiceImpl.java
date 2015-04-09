package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.account.User;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.model.journey.form.CreateStepForm;
import carpooling.repository.CityRepository;
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
import java.util.*;
import java.util.spi.CalendarNameProvider;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JourneyServiceImpl.class);
    private final JourneyRepository journeyRepository;
    private final StepService stepService;

    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository, StepService stepService) {
        this.journeyRepository = journeyRepository;
        this.stepService = stepService;
    }

    @Override
    public Journey createJourney(CreateJourneyForm form, User user) {
        LOGGER.debug("Journey creation with service");
        Journey journey = new Journey();

        //set creator
        journey.setCreator(user);

        for(CreateStepForm stepForm : form.getSteps()){
            //create step to populate
            Step step = stepService.createStep(stepForm);

            LOGGER.debug("Add step={} in journey", step);
            //finaly, adding step to journey
            journey.addStep(step);
        }

        return journeyRepository.save(journey);
    }

    @Override
    public Optional<Journey> getJourneyById(long id) {
        LOGGER.debug("Getting journey by id={}", id);
        return Optional.ofNullable(journeyRepository.findOne(id));
    }

    @Override
    public Collection<Journey> getAllJourneysByCities(List<City> cities) throws Exception {
        LOGGER.debug("Getting journeys by cities = {}", cities);
        if(cities.size() != 2)
            throw new Exception("To search a journey by cities, you must specify exactly two cities (departure and arrival). " +
                                "Number of cities passed as parameter: " + cities.size());

        //Get all the journeys with the first city from database
        List<Step> steps = (List<Step>) stepService.getAllStepsByCities(cities);
        Set<Journey> journeys = (Set<Journey>) journeyRepository.findByStepsIn(steps);

        //Look into all journeys if we find both departure and arrival cities.
        //If not, remove it from the journey list
        Iterator<Journey> iterator = journeys.iterator();
        while(iterator.hasNext()) {
            Boolean departureFound = false;
            Boolean arrivalFound = false;
            int departurePosition = 0;
            int arrivalPosition = 1;

            Journey journey = iterator.next();
            //For each step in this journey, check if we can find the departure or arrival city
            for(Step step : journey.getSteps()) {
                if(step.getCity().getId() == cities.get(0).getId())
                {
                    departureFound = true;
                    //departurePosition = step.getPosition(); ///TODO UNCOMMENT WHEN JOURNEY BRANCH IS MERGED
                }
                if(step.getCity().getId() == cities.get(1).getId())
                {
                    arrivalFound = true;
                    //arrivalPosition = step.getPosition(); ///TODO UNCOMMENT WHEN JOURNEY BRANCH IS MERGED
                }
            }
            //If at least one is missing, remove the journey from the list
            if(!departureFound || !arrivalFound)
                iterator.remove();
            else if(departurePosition > arrivalPosition)
                iterator.remove();
        }
        return journeys;
    }
}
