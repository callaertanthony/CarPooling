package carpooling.controller.journey;

import carpooling.model.journey.Journey;
import carpooling.repository.CityRepository;
import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Controller
@RequestMapping("/journey/")
public class JourneyViewController {

    @Autowired
    private CityRepository cityRepository;

    public static final Logger LOGGER = LoggerFactory.getLogger(JourneyViewController.class);
    private final JourneyService journeyService;

    @Autowired
    public JourneyViewController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @RequestMapping("/view/{id}")
    public ModelAndView getJourneyPage(@PathVariable Integer id){
        ModelAndView mvn = new ModelAndView("journey/view");
        mvn.addObject("journey", journeyService.getJourneyById(id)
            .orElseThrow(() -> new NoSuchElementException(String.format("Journey=%s not found", id))));
        return mvn;
    }

    @RequestMapping("/list")
    public ModelAndView getJourneyList(@ModelAttribute("journeys") List<Journey> journeys){
        ///TODO get and return departure & arrival cities
        ModelAndView mvn = new ModelAndView("journey/list");
        mvn.addObject("journeys", journeys);
        return mvn;
    }
}
