package com.rizomm.carpooling.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rizomm.carpooling.model.Membre;

@Component
public class MembreFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Membre.class);
		}																																																																																																					
	public void validate(Object form, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomMembre", "nomMembre.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenomMembre", "prenomMembre.required");
		
		Membre membre = (Membre) form;
		
		if (membre.getNomMembre().matches("([A-Za-z]+)")==false)	{
			errors.rejectValue("nomMembre", "invalidValue", new Object[]{"'nomMembre'"}, "caractères alphabétiques uniquement");
		}
	}
	
}
