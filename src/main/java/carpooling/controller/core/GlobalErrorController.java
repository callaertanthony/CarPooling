package carpooling.controller.core;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anthonycallaert on 03/04/15.
 */
@Controller
public class GlobalErrorController implements ErrorController {
    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping("/404")
    public String handle404(){
        return "/core/404";
    }

    @RequestMapping("/403")
    public String handle403(){
        return "/core/403";
    }
}
