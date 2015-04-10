package carpooling.controller.journey;

import carpooling.controller.core.CurrentUserControllerAdvice;
import carpooling.model.account.User;
import carpooling.model.journey.Journey;
import carpooling.model.journey.form.BookJourneyForm;
import carpooling.model.journey.form.BookJourneyFormValidator;
import carpooling.model.security.CurrentUser;
import carpooling.repository.JourneyRepository;
import carpooling.service.journey.JourneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by anthonycallaert on 09/04/15.
 */
@Controller
@RequestMapping("/journey/book")
public class JourneyBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(JourneyBookController.class);
    private final JourneyService journeyService;
    private final BookJourneyFormValidator bookJourneyFormValidator;

    @Autowired
    public JourneyBookController(JourneyService journeyService, BookJourneyFormValidator bookJourneyFormValidator) {
        this.journeyService = journeyService;
        this.bookJourneyFormValidator = bookJourneyFormValidator;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getJourneyBookPage(@PathVariable Integer id){
        LOGGER.debug("Getting book journey page for id={}", id);
        ModelAndView mvn = new ModelAndView("journey/book");
        Journey journey = journeyService.getJourneyById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Journey=%s not found", id)));
        mvn.addObject("journey", journey);
        BookJourneyForm bookJourneyForm = new BookJourneyForm();
        bookJourneyForm.setStart(journey.getFirstStep());
        bookJourneyForm.setDest(journey.getLastStep());
        mvn.addObject("journeyForm", bookJourneyForm);
        return mvn;
    }

    @InitBinder("journeyForm")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(bookJourneyFormValidator);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView handleBookJourney(@PathVariable Integer id,
                                          @Valid @ModelAttribute("journeyForm") BookJourneyForm journeyForm,
                                          BindingResult bindingResult, HttpServletRequest httpServletRequest,
                                          final RedirectAttributes redirectAttributes){
        LOGGER.debug("Processing journey book form={}, bindingResult={}", journeyForm, bindingResult);
        ModelAndView mvn = new ModelAndView("journey/book/" + id);
        if(bindingResult.hasErrors()){
            mvn.addObject("journeyForm", journeyForm);
            return mvn;
        }
        try{
            Authentication auth = (Authentication) httpServletRequest.getUserPrincipal();
            CurrentUser currentUser = CurrentUserControllerAdvice.getCurrentUser(auth);
            User user = currentUser.getUser();
            Journey journey = journeyService.bookJourney(journeyForm, user);
            redirectAttributes.addFlashAttribute("journeyBooked", journey);
            return new ModelAndView("redirect:/account/book/list");
        } catch(DataIntegrityViolationException e){
            LOGGER.warn("Exception occurred when trying to save the journey", e);
            mvn.addObject("journeyForm", journeyForm);
            return mvn;
        }
    }
}
