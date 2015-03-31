package carpooling.controller.journey;

import carpooling.model.journey.Journey;
import carpooling.model.journey.form.CreateJourneyForm;
import carpooling.model.journey.form.CreateJourneyFormValidator;
import carpooling.repository.JourneyRepository;
import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by anthonycallaert on 31/03/15.
 */
@Controller
@RequestMapping("/journey")
public class JourneyCreateController {

    public static final Logger LOGGER = LoggerFactory.getLogger(JourneyCreateController.class);
    private final JourneyService journeyService;
    private final CreateJourneyFormValidator createJourneyFormValidator;

    @Autowired
    public JourneyCreateController(JourneyService journeyService, CreateJourneyFormValidator createJourneyFormValidator) {
        this.journeyService = journeyService;
        this.createJourneyFormValidator = createJourneyFormValidator;
    }

    @InitBinder("journeyForm")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(createJourneyFormValidator);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getCreateJourneyForm(){
        LOGGER.debug("Getting create journey page");
        return new ModelAndView("journey/create", "journeyForm", new CreateJourneyForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String handleCreateJourneyForm(@Valid @ModelAttribute("journeyForm") CreateJourneyForm journeyForm, BindingResult bindingResult){
        LOGGER.debug("Processing journey create form={}, bindingResult={}", journeyForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "journey/create";
        }
        try{
            Journey journey = journeyService.createJourney(journeyForm);
            return "redirect:/journey/view/" + journey.getId();
        } catch(DataIntegrityViolationException e){
            LOGGER.warn("Exception occurred when trying to save the journey", e);
            return "journey/create";
        }
    }
}