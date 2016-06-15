package com.rm3.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.access.annotation.Secured;

import com.rm3.model.Esame;
import com.rm3.model.Medico;

public interface EsameService {
	@Secured({"ROLE_ADMIN"})
	public void insertEsame(Esame esame);
	@Secured({"ROLE_ADMIN"})
	public void updateEsame(Esame esame);
	@Secured({"ROLE_ADMIN"})
	public List<Esame> listEsamiByMedico(int id);
}
