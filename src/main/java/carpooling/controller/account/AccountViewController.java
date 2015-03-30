package carpooling.controller.account;

import carpooling.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

/**
 * Created by anthonycallaert on 30/03/15.
 */
@Controller
@RequestMapping("/account")
public class AccountViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountViewController.class);
    private final UserService userService;

    @Autowired
    public AccountViewController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/view/{id}")
    public ModelAndView getUserPage(@PathVariable Long id){
        LOGGER.debug("Getting profil page for user {}", id);
        return new ModelAndView("account/view", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

}
