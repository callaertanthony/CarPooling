package carpooling.model.journey.form;

import carpooling.model.journey.City;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateStepForm {
    @NotNull
    private City city;

    @NotNull
    private Calendar date;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
