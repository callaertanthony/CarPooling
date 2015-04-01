package carpooling.model.journey.form;

import carpooling.model.journey.Step;
import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateJourneyForm {
    private AutoPopulatingList<Step> steps = new AutoPopulatingList<Step>(Step.class);

    public AutoPopulatingList<Step> getSteps() {
        return steps;
    }

    public void setSteps(AutoPopulatingList<Step> steps) {
        this.steps = steps;
    }
}
