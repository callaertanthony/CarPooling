package com.rizomm.carpooling.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rizomm.carpooling.form.validator.MembreFormValidator;
import com.rizomm.carpooling.model.Membre;
import com.rizomm.carpooling.service.MembreService;

@Controller
@RequestMapping("/views")
public class MembreController {

	@Autowired
	private MembreFormValidator membreFormValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(membreFormValidator);
	}

	@Autowired
	private MembreService membreService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public ModelAndView getMembres() {
		ModelAndView membresView = new ModelAndView("membre");
		membresView.addObject("listMembres", this.membreService.findMembreAll());
		return membresView;
	}

	@RequestMapping(value = "/membre", method = RequestMethod.GET)
	public ModelAndView getMembre(@RequestParam(value="id", defaultValue="0") Integer id) {
		ModelAndView membresView = new ModelAndView("membre");
		membresView.addObject("getMembre", this.membreService.findMembreById(id));
		return membresView;
	}

	@ModelAttribute("membre")
	public Membre createFormModelAttribute() {
		return membreService.createMembre();
	}

	@RequestMapping(value = "/membres", method = RequestMethod.POST)
	public ModelAndView newMembre(@ModelAttribute("membre") @Valid Membre membre, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return getMembres();
		}
		this.membreService.saveMembre(membre);
		return getMembres();
	}
}
