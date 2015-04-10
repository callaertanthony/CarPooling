package carpooling.model.journey;

import carpooling.model.account.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> startPassengers = new HashSet<User>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> destPassengers = new HashSet<User>();

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

    public Set<User> getStartPassengers() {
        return startPassengers;
    }

    public void setStartPassengers(Set<User> passengers) {
        this.startPassengers = passengers;
    }

    public void addStartPassenger(User user){
        if(user != null){
            if(this.startPassengers == null){
                this.startPassengers = new HashSet<User>();
            }
            this.startPassengers.add(user);
        }
    }

    public Set<User> getDestPassengers() {
        return destPassengers;
    }

    public void setDestPassengers(Set<User> destPassengers) {
        this.destPassengers = destPassengers;
    }

    public void addDestPassenger(User user){
        if(user != null){
            if(this.destPassengers == null){
                this.destPassengers = new HashSet<User>();
            }
            this.destPassengers.add(user);
        }
    }

    public boolean haveStartPassenger(User user){
        for(User u : this.getStartPassengers()){
            if(u.getId().intValue() == user.getId().intValue())
                return true;
        }
        return false;
    }

    public boolean haveDestPassenger(User user){
        for(User u : this.getDestPassengers()){
            if(u.getId().intValue() == user.getId().intValue())
                return true;
        }
        return false;
    }
}
