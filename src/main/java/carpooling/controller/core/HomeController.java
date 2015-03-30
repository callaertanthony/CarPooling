package carpooling.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by anthonycallaert on 18/03/15.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView welcome(){
        return new ModelAndView("core/index");
    }

    //Demande de la page d'authentification
    @RequestMapping("/login")
    public ModelAndView userLogin() {
        return new ModelAndView(("core/login"));
    }

    //Demande de la page d'inscription
    @RequestMapping("/register")
    public ModelAndView userRegister() {
        return new ModelAndView(("core/register"));
    }

    //Demande de la page permettant à l'utilisateur de proposer un trajet
    @RequestMapping("/publish")
    public ModelAndView createNewJourney() {
        return new ModelAndView(("core/publish"));
    }
}
