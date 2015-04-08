package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.Step;
import carpooling.repository.StepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by anthonycallaert on 02/04/15.
 */
@Service
public class StepServiceImpl implements StepService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepServiceImpl.class);
    private final StepRepository stepRepository;

    @Autowired
    public StepServiceImpl(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    @Override
    public Collection<Step> getAllStepsByCities(Collection<City> cities) {
        List<Step> steps = (List<Step>) stepRepository.findByCityIn(cities);
        return steps;
    }
}
