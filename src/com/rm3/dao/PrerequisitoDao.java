package com.rm3.dao;

import java.util.List;

import com.rm3.model.Prerequisito;

public interface PrerequisitoDao {
	public List<Prerequisito> listPrerequisiti();
	public void insertPrerequisito(Prerequisito prerrequisito);
	public Prerequisito getPrerequisito(Integer id);
}
