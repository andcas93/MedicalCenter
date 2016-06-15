package com.rm3.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RUOLO",schema="Public")
public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String ruolo;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getRuolo(){
		return this.ruolo;
	}
	
	public void setRuolo(String ruolo){
		this.ruolo = ruolo;
	}
}
