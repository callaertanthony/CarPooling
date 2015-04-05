package carpooling.controller.core;

import carpooling.model.account.User;
import carpooling.model.security.CurrentUser;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Guillaume on 31/03/2015.
 */

/* For more information on exception handler see:
 * https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "core/error";

    @ExceptionHandler(value = AccessDeniedException.class)
    public String handleAccessDenied(){
        return "/core/403";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest httpServletRequest, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);

        return modelAndView;
    }
}
