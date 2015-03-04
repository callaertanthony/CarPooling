package com.rizomm.carpooling.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by anthonycallaert on 19/02/15.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected ModelAndView welcomeHandler(){
        ModelAndView model = new ModelAndView("core/HelloWorldPage");
        model.addObject("msg", "hello world");

        return model;
    }
}
