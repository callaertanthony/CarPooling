package carpooling.model.journey.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Guillaume on 06/04/2015.
 */
public class SearchJourneyForm {
    @NotEmpty
    private String departure = "";

    @NotEmpty
    private String arrival = "";

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "CreateAccountForm{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                '}';
    }
}
