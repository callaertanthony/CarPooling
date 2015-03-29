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
}
