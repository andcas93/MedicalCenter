package com.rm3.dao;

import java.util.List;

import com.rm3.model.TipEsame;

public interface TipEsameDao {
	public List<TipEsame> listTipEsami();
	public void insertTipEsame(TipEsame tipEsame);
	public TipEsame getTipEsame(Integer id);
	public void updateTipEsame(TipEsame tipEsame);
}
