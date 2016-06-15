package com.rm3.controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.openjpa.lib.log.Log;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import com.rm3.model.Esame;
import com.rm3.model.Medico;
import com.rm3.model.Prerequisito;
import com.rm3.model.Risultato;
import com.rm3.model.TipEsame;
import com.rm3.service.EsameService;
import com.rm3.service.MedicoService;
import com.rm3.service.PrerequisitoService;
import com.rm3.service.TipEsameService;


@RestController
@RequestMapping("/json/tipesami")
public class TipEsameController {
	@Autowired
	private TipEsameService tipEsameService;
	@Autowired
	private PrerequisitoService prerequisitoService;
	@Autowired
	private EsameService esameService;
	@Autowired
	private MedicoService medicoService;
	
	@RequestMapping(value = "/consulta",method = RequestMethod.GET)
	@ResponseBody
	public String listTipEsamiJSON() {	
		ObjectMapper mapper = new ObjectMapper();
		List<TipEsame> tipEsami = tipEsameService.listTipologieEsami();
		String json = null;
		try {
			json = mapper.writeValueAsString(tipEsami);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "/view",method = RequestMethod.POST)
	public @ResponseBody String viewEsame(@RequestBody TipEsameForm tipEsameForm){
		TipEsame tipEsame2 = tipEsameService.getTipEsame(tipEsameForm.getEsameid());
		String json = new Gson().toJson(tipEsame2);
		return json;
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	@ResponseBody
	public String demo(){
		TipEsame tipEsame = new TipEsame();
		tipEsame.setNome("Esame Emoglobina");
		tipEsame.setDescr("Alias per esame del sangue");
		tipEsame.setCod("5678");
		tipEsame.setCosto(25.45);
		Risultato risultato = new Risultato();
		risultato.setNome("Emoglobina");
		tipEsame.addRisultato(risultato);
		Prerequisito prereq = new Prerequisito();
		prereq.setNome("No-Drink");
		prereq.setDescr("Non bere nessun drink");
		tipEsame.addPrerequisito(prereq);
		this.tipEsameService.insertTipEsame(tipEsame);
		return "";
	}
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public @ResponseBody TipEsame addEsame(@RequestBody TipEsame tipEsame){
		this.tipEsameService.insertTipEsame(tipEsame);
		return tipEsame;
	}
}
