package com.rizomm.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rizomm.carpooling.model.Membre;
import com.rizomm.carpooling.service.MembreService;

@RestController
@RequestMapping("/rest")
public class MembreRestController {

	@Autowired
	private MembreService membreService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Membre> getMembres() {
		List<Membre> membres = this.membreService.findMembreAll();
		return membres;
	}
	@RequestMapping(value = "/membre/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Membre getMembre(@PathVariable Integer id) {
		Membre membre = this.membreService.findMembreById(id); 
		return membre;
	}
	
}
