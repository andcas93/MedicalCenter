package com.rm3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEDICO",schema="Public")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "NOME", length = 50)
	private String nome;
	@Column(name = "COGNOME", length = 50)
	private String cognome;
	@Column(name = "SPECIALIZZAZIONE", length = 30)
	private String specializzazione;
	@OneToMany(mappedBy="medico")
    private List<Esame> esami = new ArrayList<Esame>();

	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getCognome(){
		return this.cognome;
	}
	
	public void setCognome(String cognome){
		this.cognome = cognome;
	}
	
	public String getSpecializzazione(){
		return this.specializzazione;
	}
	
	public void setSpecializzazione(String specializzazione){
		this.specializzazione = specializzazione;
	}
	
	public List<Esame> getEsami(){
		return this.esami;
	}
	
	public void setEsami(List<Esame> esami){
		this.esami = esami;
	}
}
