package com.rm3.dao;

import java.util.List;

import com.rm3.model.Esame;
import com.rm3.model.Medico;
import com.rm3.model.Prerequisito;

public interface MedicoDao {
	public Medico getMedico(Integer id);
	public int getIdByMedico(Medico medico);
}
