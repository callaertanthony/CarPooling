package carpooling.model.journey;

import carpooling.model.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.util.AutoPopulatingList;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Entity
public class Journey {
    @GeneratedValue
    @Id
    private long id;

    @OneToMany(mappedBy = "journey", cascade = CascadeType.ALL)
    @Valid
    private List<Step> steps;

    @ManyToOne
    @CreatedBy
    private User creator;

    //TODO passengers

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
