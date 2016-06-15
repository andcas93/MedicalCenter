package com.rm3.service;

import com.rm3.model.Medico;

public interface MedicoService {
	public Medico getMedico(Integer id);
	public int getIdByMedico(Medico medico);
}
