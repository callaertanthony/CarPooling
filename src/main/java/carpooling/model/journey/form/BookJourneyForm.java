package carpooling.model.journey.form;

import carpooling.model.journey.Step;

import javax.validation.constraints.NotNull;

/**
 * Created by anthonycallaert on 09/04/15.
 */
public class BookJourneyForm {
    @NotNull
    private Step start;

    @NotNull
    private Step dest;

    public Step getStart() {
        return start;
    }

    public void setStart(Step start) {
        this.start = start;
    }

    public Step getDest() {
        return dest;
    }

    public void setDest(Step dest) {
        this.dest = dest;
    }
}
