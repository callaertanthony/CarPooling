package carpooling.model.journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AutoPopulatingList;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Step> steps;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        for (Step step : steps){
            this.addStep(step);
        }
    }

    public void addStep(Step step){
        if(step != null){
            if(steps == null){
                steps = new ArrayList<Step>();
            }
            steps.add(step);
            step.setJourney(this);
        }
    }
}
