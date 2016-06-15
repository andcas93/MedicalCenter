package com.rm3.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.TipEsame;
import com.rm3.model.Utente;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;
	
	@Override
	@Transactional
	public Utente getUser(Integer id){
		Utente e = em.createQuery("SELECT e FROM Utente e WHERE e.id="+id, Utente.class).getResultList().get(0);
		return e;
	}
}
