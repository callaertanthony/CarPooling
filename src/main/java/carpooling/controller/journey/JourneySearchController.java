package carpooling.controller.journey;

import carpooling.model.journey.City;
import carpooling.model.journey.Journey;
import carpooling.model.journey.form.SearchJourneyForm;
import carpooling.model.journey.form.SearchJourneyFormValidator;
import carpooling.repository.CityRepository;
import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillaume on 06/04/2015.
 */
@Controller
@RequestMapping("/journey")
public class JourneySearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JourneySearchController.class);
    private final JourneyViewController journeyViewController;
    private final JourneyService journeyService;
    private final SearchJourneyFormValidator searchJourneyFormValidator;


    @Autowired
    private CityRepository cityRepository;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(searchJourneyFormValidator);
    }


    @Autowired
    public JourneySearchController(JourneyService journeyService, JourneyViewController journeyViewController, SearchJourneyFormValidator searchJourneyFormValidator) {
        this.journeyService = journeyService;
        this.journeyViewController = journeyViewController;
        this.searchJourneyFormValidator = searchJourneyFormValidator;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchAllJourneys(@Valid @ModelAttribute("form") SearchJourneyForm form, BindingResult bindingResult, final RedirectAttributes redirectAttributes){
        ///TODO DO NOT FORGET TO ADD VERIFICATION ON THE TRAVELING DIRECTION (Lille -> Paris -> Lyon != Lyon -> Paris -> Lille)
        LOGGER.debug("Processing account create form={}, bindingResult={}", form, bindingResult);

        //Verify if the cities are known
        City departure = cityRepository.findByLocalityIgnoreCaseIn(form.getDeparture());
        City arrival = cityRepository.findByLocalityIgnoreCaseIn(form.getArrival());
        List<City> citiesSearched = new ArrayList<>();
        citiesSearched.add(departure);
        citiesSearched.add(arrival);

        if(bindingResult.hasErrors()){ ///TODO
            List<Journey> journeys = new ArrayList<>();
            journeyViewController.getJourneyList(journeys, departure, arrival);
        }

        List<Journey> journeys = new ArrayList<>();
        try {
            journeys = new ArrayList<>(journeyService.getAllJourneysByCities(citiesSearched));
        } catch (Exception e) {
            System.out.println("DBG - " + e.getMessage()); ///TODO Handle properly this exception
        }

        redirectAttributes.addFlashAttribute("journeys", journeys);
        redirectAttributes.addFlashAttribute("departure", departure);
        redirectAttributes.addFlashAttribute("arrival", arrival);
        return "redirect:/journey/list";
    }
}
