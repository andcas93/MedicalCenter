package com.rm3.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ESAME",schema="Public")
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Temporal (TemporalType.DATE)
	@Column(name = "DATAEFFE")
	private Date dataeffe;
	@Temporal (TemporalType.DATE)
	@Column(name = "DATAPREN")
	private Date datapren;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="TIPESAME_ID")
	private TipEsame tipesame;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="MEDICO_ID")
	private Medico medico;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="PAZIENTE_ID")
	private Utente utente;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Date getDataEffe(){
		return this.dataeffe;
	}
	
	public void setDataEffe(Date dataeff){
		this.dataeffe = dataeff;
	}
	
	public Date getDataPren(){
		return this.datapren;
	}
	
	public void setDataPren(Date datapren){
		this.datapren = datapren;
	}
	
	public TipEsame getTipEsame(){
		return this.tipesame;
	}
	
	public void setTipEsame(TipEsame tipEsame){
		this.tipesame = tipEsame;
	}
	
	public Medico getMedico(){
		return this.medico;
	}
	
	public void setMedico(Medico medico){
		this.medico = medico;
	}
	
	public Utente getUtente(){
		return this.utente;
	}
	
	public void setUtente(Utente utente){
		this.utente = utente;
	}
}