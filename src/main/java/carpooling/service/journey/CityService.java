package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.form.CreateCityForm;

import java.util.Optional;

/**
 * Created by anthonycallaert on 09/04/15.
 */
public interface CityService {
    City createCity(CreateCityForm cityForm);

    Optional<City> getCityByLocality(String locality);
}
