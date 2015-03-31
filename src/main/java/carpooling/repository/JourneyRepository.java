package carpooling.repository;

import carpooling.model.journey.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface JourneyRepository extends JpaRepository<Journey, Long> {
}
