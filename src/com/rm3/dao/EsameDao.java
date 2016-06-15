package com.rm3.dao;

import java.util.List;
import java.util.Set;

import com.rm3.model.Esame;
import com.rm3.model.Medico;
import com.rm3.model.TipEsame;

public interface EsameDao {
	public void insertEsame(Esame esame);
	public void updateEsame(Esame esame);
	public List<Esame> listEsamiByMedico(int id);
}
