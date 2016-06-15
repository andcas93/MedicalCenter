package com.rm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.TipEsameDao;
import com.rm3.dao.UserDao;
import com.rm3.model.TipEsame;
import com.rm3.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService{
	@Autowired
	private UserDao utenteDao;

	@Override
	public Utente getUtente(Integer id) {
		return this.utenteDao.getUser(id);
	}

}
