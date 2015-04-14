package carpooling.repository;

import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface JourneyRepository extends JpaRepository<Journey, Long> {
    Set<Journey> findByStepsIn(Collection<Step> steps);
}
