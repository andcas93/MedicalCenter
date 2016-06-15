package com.rm3.service;

import org.springframework.security.access.annotation.Secured;

import com.rm3.model.TipEsame;
import com.rm3.model.Utente;

public interface UtenteService {
	@Secured({"ROLE_ADMIN"})
	public Utente getUtente(Integer id);
}
