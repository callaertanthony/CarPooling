package carpooling.service.journey;

import carpooling.model.journey.City;
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
    private final CityRepository cityRepository;

    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository, StepService stepService, CityRepository cityRepository) {
        this.journeyRepository = journeyRepository;
        this.stepService = stepService;
        this.cityRepository = cityRepository;
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
        LOGGER.debug("Getting journey by id={}", id);
        return Optional.ofNullable(journeyRepository.findOne(id));
    }

    @Override
    public Collection<Journey> getAllJourneysByCitiesName(Collection<String> citiesNames) {
        LOGGER.debug("Getting journeys by cities names = {}", citiesNames);
        List<City> cities = (List<City>) cityRepository.findByNameIgnoreCaseIn(citiesNames);
        List<Step> steps = (List<Step>) stepService.getAllStepsByCities(cities);
        List<Journey> journeys = (List<Journey>) journeyRepository.findByStepsIn(steps);
        return journeys;
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
        System.out.println("PROBLEM WITH THIS LIST SIZE: " + journeys.size()); ///TODO find out why we get all journey twice in this list

        //Look into all journeys if we find both departure and arrival cities.
        //If not, remove it from the journey list
        Iterator<Journey> iterator = journeys.iterator();
        while(iterator.hasNext()) {
            Boolean departureFound = false;
            Boolean arrivalFound = false;
            Journey journey = iterator.next();
            //For each step in this journey, check if we can find the departure or arrival city
            for(Step step : journey.getSteps()) {
                if(step.getCity().getId() == cities.get(0).getId())
                    departureFound = true;
                if(step.getCity().getId() == cities.get(1).getId())
                    arrivalFound = true;
            }
            //If at least one is missing, remove the journey from the list
            if(!departureFound || !arrivalFound)
                iterator.remove();
            System.out.println("here 32");
        }
        return journeys;
    }
}
