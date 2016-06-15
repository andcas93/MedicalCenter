package com.rm3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rm3.model.Medico;
import com.rm3.model.TipEsame;


@Controller
@RequestMapping("/home")
public class PageController {
	@RequestMapping(value = "/tipesami", method = RequestMethod.GET)
	public String tipEsami(Model model){
		return "/tipesami";
	}
	
	@ModelAttribute("tipesame")
	public TipEsame createTipEsame() {
		return new TipEsame();
	}
	
	@ModelAttribute("medico")
	public Medico createMedico() {
		return new Medico();
	}
	
	@ModelAttribute("prerequisito")
	public TipEsame createPrerequisito() {
		return new TipEsame();
	}
	
	@ModelAttribute("esameform")
	public EsameForm createEsameForm() {
		return new EsameForm();
	}
	
	@ModelAttribute("tipesameform")
	public TipEsameForm createTipEsameForm() {
		return new TipEsameForm();
	}
}
