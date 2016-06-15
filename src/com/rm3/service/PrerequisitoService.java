package com.rm3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.rm3.model.Prerequisito;

public interface PrerequisitoService {
	
	public List<Prerequisito> listPrerequisiti();
	
	@Secured({"ROLE_ADMIN"})
	public void insertPrerequisito(Prerequisito prerequisito);
	
	public Prerequisito getPrerequisito(Integer id);
}
