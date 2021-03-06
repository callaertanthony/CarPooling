package carpooling.service;

import carpooling.model.account.User;
import carpooling.model.account.form.AccountCreateForm;
import carpooling.model.account.form.AccountModifyForm;
import carpooling.model.security.form.UserCrudCreateForm;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by anthonycallaert on 19/03/15.
 */
public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User createUser(UserCrudCreateForm form);

    User createAccount(AccountCreateForm form);

    User modifyAccount(AccountModifyForm form, User user);
}
