package com.rm3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.rm3.model.TipEsame;

public interface TipEsameService {
	public List<TipEsame> listTipologieEsami();
	
	public TipEsame getTipEsame(Integer id);

	@Secured({"ROLE_ADMIN"})
	public void insertTipEsame(TipEsame tipEsame);
	
	@Secured({"ROLE_ADMIN"})
	public void updateTipEsame(TipEsame tipEsame);
}
