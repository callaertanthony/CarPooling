package carpooling.repository;

import carpooling.model.journey.Step;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public interface StepRepository extends JpaRepository<Step, Long> {
}
