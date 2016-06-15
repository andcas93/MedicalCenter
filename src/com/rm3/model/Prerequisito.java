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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PREREQUISITO",schema="Public")
public class Prerequisito {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "NOME", length = 30)
	private String nome;
	@Column(name = "DESCR", length = 50)
	private String descr;

	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id ;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getDescr(){
		return this.descr;
	}
	
	public void setDescr(String descr){
		this.descr = descr;
	}
	
}
