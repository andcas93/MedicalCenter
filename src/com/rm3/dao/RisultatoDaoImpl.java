package com.rm3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.Risultato;
import com.rm3.model.TipEsame;

@Repository
public class RisultatoDaoImpl implements RisultatoDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;
	
	@Transactional
	public List<Risultato> listRisultati() {
		List<Risultato> risultati = em.createQuery("SELECT e FROM Risultato e", Risultato.class).getResultList();
		return risultati;
	}
}
