package carpooling.model.journey;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Set;

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

    @OneToMany(mappedBy = "journey")
    private ArrayList<Step> steps;

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
