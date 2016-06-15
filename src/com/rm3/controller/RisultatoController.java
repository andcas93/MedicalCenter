package com.rm3.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rm3.model.Risultato;
import com.rm3.model.TipEsame;
import com.rm3.service.EsameService;
import com.rm3.service.MedicoService;
import com.rm3.service.PrerequisitoService;
import com.rm3.service.RisultatoService;
import com.rm3.service.TipEsameService;

@RestController
@RequestMapping("/json/risultati")
public class RisultatoController {
	@Autowired
	private RisultatoService risultatoService;
	
	@RequestMapping(value = "/consulta",method = RequestMethod.GET)
	@ResponseBody
	public String listTipEsamiJSON() {	
		ObjectMapper mapper = new ObjectMapper();
		List<Risultato> risultati = risultatoService.listRisultati();
		String json = null;
		try {
			json = mapper.writeValueAsString(risultati);
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
}