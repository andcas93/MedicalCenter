package com.rm3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rm3.model.TipEsame;


@Repository
public class TipEsameDaoImpl implements TipEsameDao{
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;
	
	@Transactional
	public List<TipEsame> listTipEsami() {
		List<TipEsame> esamiList = em.createQuery("SELECT e.id,e.nome FROM TipEsame e", TipEsame.class).getResultList();
		return esamiList;
	}

	@Override
	@Transactional
	public void insertTipEsame(TipEsame tipEsame) {
		em.persist(tipEsame);
	}
	
	@Override
	@Transactional
	public TipEsame getTipEsame(Integer id){
		TipEsame e = em.createQuery("SELECT e FROM TipEsame e WHERE e.id="+id, TipEsame.class).getResultList().get(0);
		return e;
	}
	
	@Override
	@Transactional
	public void updateTipEsame(TipEsame tipEsame){
		em.merge(tipEsame);
	}
}
