package carpooling.model.journey.form;

import carpooling.model.journey.Step;
import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateJourneyForm {
    private List<Step> steps = new AutoPopulatingList<Step>(Step.class);

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
