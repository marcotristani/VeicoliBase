package com.betacom.veicoli.models;

public class Bici extends Veicoli{

	private Integer numeroMarce;
	private Integer numeroCorone;
	private String tipoFreno;
	private String tipoSospensione;
	private Boolean pieghevole;
	
	
	public Bici(String tipoVeicolo,Integer numeroRuote, String tipoAlimentazione, String categoria, String colore,
			String marca, Integer annoProduzione, String modello, Integer numeroMarce, Integer numeroCorone,
			String tipoFreno, String tipoSospensione, Boolean pieghevole) {
		super(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello);
		this.numeroMarce = numeroMarce;
		this.numeroCorone = numeroCorone;
		this.tipoFreno = tipoFreno;
		this.tipoSospensione = tipoSospensione;
		this.pieghevole= pieghevole;
		
	}
	public Integer getNumeroMarce() {
		return numeroMarce;
	}
	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}
	public Integer getNumeroCorone() {
		return numeroCorone;
	}
	public void setNumeroCorone(Integer numeroCorone) {
		this.numeroCorone = numeroCorone;
	}
	public String getTipoFreno() {
		return tipoFreno;
	}
	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}
	public String getTipoSospensione() {
		return tipoSospensione;
	}
	public void setTipoSospensione(String tipoSospensione) {
		this.tipoSospensione = tipoSospensione;
	}
	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}
	
	@Override
	public String toString() {
		return "Bici [Id = " + getId() +", Numero ruote = "+ getNumeroRuote() + ", Tipo alimentazione = " + getTipoAlimentazione() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Anno produzione = " + getAnnoProduzione()
				+ ", Numero marce =  "+getNumeroMarce() +", Numero corone = " + getNumeroCorone()+", Tipo freno = " + getTipoFreno() + ", Tipo Sospensioni = " + getTipoSospensione()+ ",Pieghevole = " +( getPieghevole()? "si" : "no") + " ]";
	}
	
	
}
