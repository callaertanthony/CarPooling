package carpooling.controller.core;

import carpooling.model.account.User;
import carpooling.model.security.CurrentUser;
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

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView welcome(HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("core/index");

        //Looking if an user is connected. If yes, return him as an object to the JSP
        Authentication auth = (Authentication) httpServletRequest.getUserPrincipal();
        if(null != auth)
        {
            CurrentUser currentUser = CurrentUserControllerAdvice.getCurrentUser(auth);
            User user = currentUser.getUser();
            modelAndView.addObject("userConnected", user);
        }
        return modelAndView;
    }


    //Demande de la page permettant à l'utilisateur de proposer un trajet
    @RequestMapping("/publish")
    public ModelAndView createNewJourney() {
        return new ModelAndView(("core/publish"));
    }
}
