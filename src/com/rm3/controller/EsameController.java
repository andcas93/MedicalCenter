package com.rm3.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rm3.model.Esame;
import com.rm3.model.Medico;
import com.rm3.model.Prerequisito;
import com.rm3.model.TipEsame;
import com.rm3.model.Utente;
import com.rm3.service.EsameService;
import com.rm3.service.MedicoService;
import com.rm3.service.PrerequisitoService;
import com.rm3.service.TipEsameService;
import com.rm3.service.UtenteService;

@RestController
@RequestMapping("/json/esami")
public class EsameController {
	@Autowired
	private EsameService esameService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private TipEsameService tipEsameService;
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/medico", method = RequestMethod.POST)
	public @ResponseBody String listEsamiMedicoJSON(@RequestBody Medico medico){
		int id = medicoService.getIdByMedico(medico);
		List<Esame> esami = esameService.listEsamiByMedico(id);
		String json = new Gson().toJson(esami);
		return json;
	}
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public @ResponseBody EsameForm addEsame(@RequestBody EsameForm esameForm){
		Esame esame = new Esame();
		Date date = new java.sql.Date(System.currentTimeMillis());
		esame.setDataPren(date);
		Medico medico = medicoService.getMedico(Integer.parseInt(esameForm.getMedico()));
		esame.setMedico(medico);
		TipEsame tipEsame = tipEsameService.getTipEsame(Integer.parseInt(esameForm.getTipesame()));
		esame.setTipEsame(tipEsame);
		Utente utente  = utenteService.getUtente(Integer.parseInt(esameForm.getUtente()));
		esame.setUtente(utente);
		this.esameService.insertEsame(esame);
		return esameForm;
	}
}
