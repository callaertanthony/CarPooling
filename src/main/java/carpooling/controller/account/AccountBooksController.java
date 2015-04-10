package carpooling.controller.account;

import carpooling.controller.core.CurrentUserControllerAdvice;
import carpooling.model.account.User;
import carpooling.model.journey.Journey;
import carpooling.model.security.CurrentUser;
import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anthonycallaert on 10/04/15.
 */
@Controller
@RequestMapping("/account/book")
public class AccountBooksController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountBooksController.class);
    private final JourneyService journeyService;

    @Autowired
    public AccountBooksController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @RequestMapping("/list")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getBooksListPage(@ModelAttribute("journeyBooked") Journey journeyCreated,
                                         HttpServletRequest httpServletRequest){
        LOGGER.debug("Getting booked journeys page");
        Authentication auth = (Authentication) httpServletRequest.getUserPrincipal();
        CurrentUser currentUser = CurrentUserControllerAdvice.getCurrentUser(auth);
        User user = currentUser.getUser();
        ModelAndView mvn = new ModelAndView("account/book/list");
        mvn.addObject("currentUser", user);
        mvn.addObject("journeys", journeyService.getAllJourneysByUser(user));

        return mvn;
    }
}
