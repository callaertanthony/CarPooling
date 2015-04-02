package carpooling.model.journey.form;

import carpooling.model.journey.Step;
import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateJourneyForm {
    private List<CreateStepForm> steps = new AutoPopulatingList<CreateStepForm>(CreateStepForm.class);

    public List<CreateStepForm> getSteps() {
        return steps;
    }

    public void setSteps(List<CreateStepForm> steps) {
        this.steps = steps;
    }
}
