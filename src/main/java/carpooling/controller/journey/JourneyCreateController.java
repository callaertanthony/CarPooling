package carpooling.controller.journey;

import carpooling.controller.core.CurrentUserControllerAdvice;
import carpooling.model.account.User;
import carpooling.model.journey.Journey;
import carpooling.model.journey.Step;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.model.journey.form.CreateJourneyFormValidator;
import carpooling.model.security.CurrentUser;
import carpooling.repository.CityRepository;
import carpooling.repository.JourneyRepository;
import carpooling.service.journey.JourneyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Controller
@RequestMapping("/journey")
public class JourneyCreateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JourneyCreateController.class);
    private final JourneyService journeyService;
    private final CreateJourneyFormValidator createJourneyFormValidator;
    //TODO change for a service
    private final CityRepository cityRepository;

    @Autowired
    public JourneyCreateController(JourneyService journeyService,
                                   CreateJourneyFormValidator createJourneyFormValidator, CityRepository cityRepository) {
        this.journeyService = journeyService;
        this.createJourneyFormValidator = createJourneyFormValidator;
        this.cityRepository = cityRepository;

    }

    @InitBinder("journeyForm")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(createJourneyFormValidator);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getCreateJourneyForm(){
        LOGGER.debug("Getting create journey page");
        ModelAndView mvn = new ModelAndView("journey/create");
        mvn.addObject("journeyForm", new CreateJourneyForm());

        Calendar calendar = Calendar.getInstance();
        mvn.addObject("todayDate", calendar.getTime());
        return mvn;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView handleCreateJourneyForm(@Valid @ModelAttribute("journeyForm") CreateJourneyForm journeyForm,
                                                BindingResult bindingResult, HttpServletRequest httpServletRequest){
        LOGGER.debug("Processing journey create form={}, bindingResult={}", journeyForm, bindingResult);
        ModelAndView mvn = new ModelAndView("journey/create");
        if(bindingResult.hasErrors()){
            mvn.addObject("journeyForm", journeyForm);
            return mvn;
        }
        try{
            Authentication auth = (Authentication) httpServletRequest.getUserPrincipal();
            CurrentUser currentUser = CurrentUserControllerAdvice.getCurrentUser(auth);
            User user = currentUser.getUser();
            Journey journey = journeyService.createJourney(journeyForm, user);
            return new ModelAndView("redirect:/journey/view/" + journey.getId());
        } catch(DataIntegrityViolationException e){
            LOGGER.warn("Exception occurred when trying to save the journey", e);
            mvn.addObject("journeyForm", journeyForm);
            return mvn;
        }
    }
}
