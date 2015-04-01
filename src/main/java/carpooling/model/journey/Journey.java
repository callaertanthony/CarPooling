package carpooling.model.journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AutoPopulatingList;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Entity
public class Journey {
    @GeneratedValue
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "journey", cascade = CascadeType.ALL)
    private List<Step> steps = new AutoPopulatingList<Step>(Step.class);

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
