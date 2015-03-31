package carpooling.repository;

import carpooling.model.journey.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
