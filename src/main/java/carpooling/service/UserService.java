package carpooling.service;

import carpooling.model.security.User;
import carpooling.model.security.form.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by anthonycallaert on 19/03/15.
 */
public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
