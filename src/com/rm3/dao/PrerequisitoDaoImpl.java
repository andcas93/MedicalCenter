package com.rm3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.Prerequisito;
import com.rm3.model.TipEsame;

@Repository
public class PrerequisitoDaoImpl implements PrerequisitoDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<Prerequisito> listPrerequisiti() {
		List<Prerequisito> prereqList = em.createQuery("SELECT e FROM Prerequisito e",Prerequisito.class).getResultList();
		return prereqList;
	}

	@Transactional
	@Override
	public void insertPrerequisito(Prerequisito prerequisito) {
		em.persist(prerequisito);
	}
	
	@Transactional
	@Override
	public Prerequisito getPrerequisito(Integer id){
		Prerequisito e = em.find(Prerequisito.class, id);
		return e;
	}
}
