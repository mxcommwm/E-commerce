package com.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class FormCard {
	private String token;
	private String titularCard;
	private String numberCard;
	private int mes;
	private int anio;
	private int codigoCard;
	
	public FormCard() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTitularCard() {
		return titularCard;
	}

	public void setTitularCard(String titularCard) {
		this.titularCard = titularCard;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getCodigoCard() {
		return codigoCard;
	}

	public void setCodigoCard(int codigoCard) {
		this.codigoCard = codigoCard;
	}
	

}
