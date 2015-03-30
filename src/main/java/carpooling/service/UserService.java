package carpooling.service;

import carpooling.model.account.User;
import carpooling.model.account.form.CreateAccountForm;
import carpooling.model.security.form.UserCrudCreateForm;

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

    User createAccount(CreateAccountForm form);
}
