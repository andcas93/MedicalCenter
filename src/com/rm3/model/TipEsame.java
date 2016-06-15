package com.rm3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TIPESAME",schema="Public")
public class TipEsame {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "NOME", length = 50)
	private String nome;
	@Column(name = "COD", length = 10)
	private String cod;
	@Column(name = "DESCR", length = 100)
	private String descr;
	@Column(name = "COSTO")
	private Double costo;
	@OneToMany(cascade = {CascadeType.ALL},targetEntity=Risultato.class,fetch = FetchType.EAGER)
	private List<Risultato> risultati = new ArrayList<Risultato>();
	@OneToMany( cascade = {CascadeType.ALL},targetEntity=Prerequisito.class,fetch = FetchType.EAGER)
	private List<Prerequisito> prerequisiti = new ArrayList<Prerequisito>();
	
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
	
	public String getCod(){
		return this.cod;
	}
	
	public void setCod(String cod){
		this.cod = cod;
	}
	
	public String getDescr(){
		return this.descr;
	}
	
	public void setDescr(String descr){
		this.descr = descr;
	}
	
	public Double getCosto(){
		return this.costo;
	}
	
	public void setCosto(Double costo){
		this.costo = costo;
	}
	
	public List<Prerequisito> getPrerequisiti(){
		return this.prerequisiti;
	}
	
	public void setPrerequisiti(List<Prerequisito> prerequisiti){
		this.prerequisiti = prerequisiti;
	}
	
	public void addPrerequisito(Prerequisito prerequisito){
		this.prerequisiti.add(prerequisito);
	}
	
	public List<Risultato> getRisultati(){
		return this.risultati;
	}
	
	public void setRisultati(List<Risultato> risultati){
		this.risultati = risultati;
	}
	
	public void addRisultato(Risultato risultato){
		this.risultati.add(risultato);
	}
}
