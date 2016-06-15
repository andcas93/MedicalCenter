package com.rm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.PrerequisitoDao;
import com.rm3.model.Prerequisito;

@Service
public class PrerequisitoServiceImpl implements PrerequisitoService {
	
	@Autowired
	private PrerequisitoDao prerequisitoDao;
	
	@Override
	public List<Prerequisito> listPrerequisiti() {
		return this.prerequisitoDao.listPrerequisiti();
	}

	@Override
	public void insertPrerequisito(Prerequisito prerequisito) {
		this.prerequisitoDao.insertPrerequisito(prerequisito);
	}
	
	@Override
	public Prerequisito getPrerequisito(Integer id){
		return this.prerequisitoDao.getPrerequisito(id);
	}

}