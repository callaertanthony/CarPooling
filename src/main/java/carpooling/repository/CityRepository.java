package carpooling.repository;

import carpooling.model.journey.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface CityRepository extends JpaRepository<City, Long> {

    Collection<City> findByNameIgnoreCaseIn(Collection<String> citiesNames);
}
