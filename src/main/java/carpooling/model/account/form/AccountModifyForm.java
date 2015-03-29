package carpooling.model.account.form;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by anthonycallaert on 29/03/15.
 */
public class AccountModifyForm {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountModifyForm() {
        this.email = "";
    }

    public AccountModifyForm(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AccountModifyForm{" +
                "email='" + email + '\'' +
                '}';
    }
}
