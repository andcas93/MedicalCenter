package com.rm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.PrerequisitoDao;
import com.rm3.dao.RisultatoDao;
import com.rm3.model.Risultato;

@Service
public class RisultatoServiceImpl implements RisultatoService {

	@Autowired
	private RisultatoDao risultatoDao;
	
	@Override
	public List<Risultato> listRisultati() {
		return this.risultatoDao.listRisultati();
	}

}
