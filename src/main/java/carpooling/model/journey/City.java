package carpooling.model.journey;

import javax.persistence.*;
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
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
