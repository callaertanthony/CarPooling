package carpooling.model.journey.form;

import carpooling.model.journey.Step;

import java.util.ArrayList;

/**
 * Created by anthonycallaert on 31/03/15.
 */
public class CreateJourneyForm {
    private ArrayList<Step> steps = new ArrayList<Step>();

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
