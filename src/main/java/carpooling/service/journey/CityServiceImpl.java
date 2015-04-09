package carpooling.service.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.form.CreateCityForm;
import carpooling.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by anthonycallaert on 09/04/15.
 */
@Service
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City createCity(CreateCityForm cityForm) {
        City city = getCityByLocality(cityForm.getLocality())
                .orElse(
                        new City());
        if(null == city.getLocality()){
            city.setLocality(cityForm.getLocality());
            city.setLatitude(cityForm.getLatitude());
            city.setLongitude(cityForm.getLongitude());
        }
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> getCityByLocality(String locality) {
        LOGGER.debug("Getting city by locality ={}", locality);
        return Optional.ofNullable(cityRepository.findByLocalityIgnoreCaseIn(locality));
    }
}
