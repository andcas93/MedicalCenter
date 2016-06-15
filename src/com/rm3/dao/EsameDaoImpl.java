package com.rm3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.Esame;
import com.rm3.model.Medico;
import com.rm3.model.TipEsame;

@Repository
public class EsameDaoImpl implements EsameDao{
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Transactional
	@Override
	public void insertEsame(Esame esame) {
		em.persist(esame);
	}
	
	@Transactional
	@Override
	public void updateEsame(Esame esame){
		em.merge(esame);
	}
	
	@Transactional
	@Override
	public List<Esame> listEsamiByMedico(int id){
		List<Esame> esami = em.createQuery("SELECT e.id,e.tipesame.nome,e.datapren,e.utente.nome,e.utente.cognome FROM Esame e WHERE e.medico.id="+id, Esame.class).getResultList();
		return esami;
	}
}
