package carpooling.repository;

import carpooling.model.account.User;
import carpooling.model.journey.City;
import carpooling.model.journey.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Set;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface StepRepository extends JpaRepository<Step, Long> {

    Collection<Step> findByCityIn(Collection<City> cities);

    Set<Step> findByDestPassengers(User user);
    Set<Step> findByStartPassengers(User user);
}
