package com.rm3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm3.dao.TipEsameDao;
import com.rm3.model.TipEsame;

@Service
public class TipEsameServiceImpl implements TipEsameService {
	
	@Autowired
	private TipEsameDao tipEsameDao;
	
	@Override
	public List<TipEsame> listTipologieEsami() {
		return this.tipEsameDao.listTipEsami();
	}

	@Override
	public void insertTipEsame(TipEsame tipEsame) {
		this.tipEsameDao.insertTipEsame(tipEsame);
	}

	@Override
	public TipEsame getTipEsame(Integer id) {
		return this.tipEsameDao.getTipEsame(id);
	}
	
	@Override
	public void updateTipEsame(TipEsame tipEsame){
		this.tipEsameDao.updateTipEsame(tipEsame);
	}
}
