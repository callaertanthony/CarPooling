package carpooling.controller.core;

import carpooling.model.account.User;
import carpooling.model.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anthonycallaert on 18/03/15.
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView welcome(HttpServletRequest httpServletRequest){
        LOGGER.debug("Getting home page");
        ModelAndView modelAndView = new ModelAndView("core/index");

        return modelAndView;
    }


    //Demande de la page permettant à l'utilisateur de proposer un trajet
    @RequestMapping("/publish")
    public ModelAndView createNewJourney() {
        return new ModelAndView(("core/publish"));
    }
}
