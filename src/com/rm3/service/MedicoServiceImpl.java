package com.rm3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.MedicoDao;
import com.rm3.model.Medico;
import com.rm3.model.Prerequisito;

@Service
public class MedicoServiceImpl implements MedicoService {
	@Autowired
	MedicoDao medicoDao;
	
	@Override
	public Medico getMedico(Integer id){
		return this.medicoDao.getMedico(id);
	}
	
	@Override
	public int getIdByMedico(Medico medico){
		return this.medicoDao.getIdByMedico(medico);
	}
}
