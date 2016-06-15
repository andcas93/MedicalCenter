package com.rm3.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rm3.model.Prerequisito;
import com.rm3.service.PrerequisitoService;


@RestController
@RequestMapping("/json/prerequisiti")
public class PrerequisitoController {
	@Autowired
	private PrerequisitoService prerequisitoService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public String listPrerequisitiJSON() {	
		List<Prerequisito> prerequisiti = prerequisitoService.listPrerequisiti();
		String json = new Gson().toJson(prerequisiti);
		return json;
	}
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public @ResponseBody Prerequisito addPrerequisito(@RequestBody Prerequisito prerequisito){
		this.prerequisitoService.insertPrerequisito(prerequisito);
		return prerequisito;
	}
}
