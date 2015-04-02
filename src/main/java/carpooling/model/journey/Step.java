package carpooling.model.journey;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Entity
public class Step {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Journey journey;

    @ManyToOne
    private City city;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Calendar dateCalendar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Calendar getDateCalendar() {
        return dateCalendar;
    }

    public void setDateCalendar(Calendar dateCalendar) {
        this.dateCalendar = dateCalendar;
    }
}
