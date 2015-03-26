package carpooling.service.currentuser;

import carpooling.model.security.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
