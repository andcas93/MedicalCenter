package com.rm3.controller;

import java.io.Serializable;

public class EsameForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String medico;
	private String tipesame;
	private String utente;
	
	public String getMedico(){
		return this.medico;
	}
	
	public void setMedico(String medico){
		this.medico = medico;
	}
	
	public String getTipesame(){
		return this.tipesame;
	}
	
	public void setTipesame(String tipesame){
		this.tipesame = tipesame;
	}
	
	public void setUtente(String utente){
		this.utente = utente;
	}
	
	public String getUtente(){
		return this.utente;
	}
}
