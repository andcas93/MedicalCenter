package com.rm3.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.EsameDao;
import com.rm3.model.Esame;
import com.rm3.model.Medico;

@Service
public class EsameServiceImpl implements EsameService {
	@Autowired
	private EsameDao esameDao;
	
	@Override
	public void insertEsame(Esame esame) {
		esameDao.insertEsame(esame);
	}
	
	@Override
	public void updateEsame(Esame esame){
		esameDao.updateEsame(esame);
	}
	
	@Override
	public List<Esame> listEsamiByMedico(int id){
		return esameDao.listEsamiByMedico(id);
	}
}
	
