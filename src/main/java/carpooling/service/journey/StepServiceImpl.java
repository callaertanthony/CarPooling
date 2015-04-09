package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateCityForm;
import carpooling.model.journey.form.CreateStepForm;
import carpooling.repository.StepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * Created by anthonycallaert on 02/04/15.
 */
@Service
public class StepServiceImpl implements StepService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepServiceImpl.class);
    private final StepRepository stepRepository;
    private final CityService cityService;

    @Autowired
    public StepServiceImpl(StepRepository stepRepository, CityService cityService) {
        this.stepRepository = stepRepository;
        this.cityService = cityService;
    }

    @Override
    public Collection<Step> getAllStepsByCities(Collection<City> cities) {
        List<Step> steps = (List<Step>) stepRepository.findByCityIn(cities);
        return steps;
    }

    @Override
    public Step createStep(CreateStepForm stepForm) {
        Calendar calendar = Calendar.getInstance();

        //set date
        LocalDate date = stepForm.getDate();;
        LocalTime time = stepForm.getTime();;

        Step step = new Step();

        calendar.set(Calendar.YEAR, date.getYear());
        calendar.set(Calendar.MONTH, date.getMonth().getValue());
        calendar.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
        calendar.set(Calendar.HOUR_OF_DAY, time.getHour());
        calendar.set(Calendar.MINUTE, time.getMinute());
        step.setDateCalendar(calendar);

        //set city

        City city = cityService.createCity(stepForm.getCity());
        city.addStep(step);

        return stepRepository.save(step);
    }
}
