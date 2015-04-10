package carpooling.model.journey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Entity
public class City {
    @GeneratedValue
    @Id
    private long id;

    @OneToMany(mappedBy = "city")
    private Set<Step> steps;

    @Basic
    @Column(nullable = false, unique = true)
    private String locality;

    @Basic
    @Column(nullable = false)
    private float latitude;

    @Basic
    @Column(nullable = false)
    private float longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String name) {
        this.locality = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void addStep(Step step){
        if(step != null){
            if(steps == null){
                steps = new HashSet<Step>();
            }
            steps.add(step);
            step.setCity(this);
        }
    }
}
