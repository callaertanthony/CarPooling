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

    @OneToMany(mappedBy = "journey")
    @Valid
    private List<Step> steps;

    @ManyToOne(optional = false)
    @CreatedBy
    private User creator;

    //TODO change for a vehicle
    @Basic
    private int seats = 5;

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

    public Step getFirstStep() {
        if(steps != null && !steps.isEmpty())
        {
            return this.steps.get(0);
        }
        return new Step();
    }

    public Step getLastStep() {
        if(steps != null && !steps.isEmpty())
        {
            return this.steps.get(steps.size()-1);
        }
        return new Step();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
