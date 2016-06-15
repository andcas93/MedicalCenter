package com.rm3.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.Medico;

@Repository
public class MedicoDaoImpl implements MedicoDao {
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;
	
	@Transactional
	@Override
	public Medico getMedico(Integer id){
		Medico e = em.createQuery("Select m FROM Medico m where m.id="+id,Medico.class).getSingleResult();
		return e;
	}
	
	@Transactional
	@Override
	public int getIdByMedico(Medico medico){
		Medico m = em.createQuery("Select m FROM Medico m where m.nome='"+medico.getNome()+"' AND m.cognome='"+medico.getCognome()+"'",Medico.class).getResultList().get(0);
		return m.getId();
	}
}
