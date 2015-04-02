package carpooling.repository;

import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface JourneyRepository extends JpaRepository<Journey, Long> {
    //SELECT DISTINCT step.journey_id FROM journey, step WHERE step.`city_id`='1' OR step.`city_id`='2'


    //List<Journey> findByStepsCityOrStepsCity(City departure, City arrival);

    //@Query("SELECT DISTINCT Journey FROM Journey, Step WHERE step.`city_id` = ?1 OR step.`city_id` = ?2")
    //List<Journey> findAllJourneyByCities(long departure, long arrival);
    //If we can't make it works: Alternative is to take only the arrival city and retrieve this all list.
    //Then, we will be able to evaluate the traject matching (passing by the departure, good direction)

    Collection<Journey> findByStepsIn(Collection<Step> steps);
}
