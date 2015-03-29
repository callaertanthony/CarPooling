package carpooling.controller.account;

import carpooling.model.account.form.CreateAccountForm;
import carpooling.model.account.form.CreateAccountFormValidator;
import carpooling.service.UserService;
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
 * Created by anthonycallaert on 26/03/15.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    private final UserService userService;
    private final CreateAccountFormValidator createAccountFormValidator;

    @Autowired
    public AccountController(UserService userService, CreateAccountFormValidator createAccountFormValidator) {
        this.userService = userService;
        this.createAccountFormValidator = createAccountFormValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(createAccountFormValidator);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public ModelAndView getCreateAccountForAnonymousPage(){
        LOGGER.debug("Getting account create form");
        return new ModelAndView("/account/create", "form", new CreateAccountForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String handleCreateAccountForm(@Valid @ModelAttribute("form") CreateAccountForm form, BindingResult bindingResult){
        LOGGER.debug("Processing account create form={}, bindingResult={}", form, bindingResult);
        if(bindingResult.hasErrors()){
            return "account/create";
        }
        try{
            userService.createAccount(form);
        } catch(DataIntegrityViolationException e){
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "account/create";
        }

        //TODO redirect to success account created page
        return "redirect:/home";
    }
}
