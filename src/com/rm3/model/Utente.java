package com.rm3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UTENTE",schema="Public")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private int enabled;
	/*
	@ManyToOne
	@JoinTable(name="UTENTERUOLO",
			joinColumns = @JoinColumn(name = "utente_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "ruolo_id",referencedColumnName = "id"))
	private Ruolo ruolo;
	*/
	@OneToMany(mappedBy="utente")
    private List<Esame> esami = new ArrayList<Esame>();
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getCognome(){
		return cognome;
	}
	
	public void setCognome(String cognome){
		this.cognome = cognome;
	}

	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return this.password;
	}
	
	public void setEnabled(int enabled){
		this.enabled = enabled;
	}
	
	public int getEnabled(){
		return this.enabled;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	/*
	public Ruolo getRuolo(){
		return ruolo;
	}
	
	
	public void setRuolo(Ruolo ruolo){
		this.ruolo = ruolo;
	}
	*/
	
	public List<Esame> getEsami(){
		return this.esami;
	}
	
	public void setEsami(List<Esame> esami){
		this.esami = esami;
	}
	
}
