package carpooling.model.journey.form;

import javax.validation.constraints.NotNull;

/**
 * Created by anthonycallaert on 09/04/15.
 */
public class CreateCityForm {

    @NotNull
    private String locality;

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

    public String getLocality() {
        return locality;
    }

    public CreateCityForm(String locality, float latitude, float longitude) {
        this.locality = locality;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
