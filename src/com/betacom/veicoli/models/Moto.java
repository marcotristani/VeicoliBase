package com.betacom.veicoli.models;

public class Moto extends Veicoli{

	private String targa;
	private Integer cc;
	
	
	public Moto(String tipoVeicolo,Integer numeroRuote, String tipoAlimentazione, String categoria, String colore,
			String marca, Integer annoProduzione, String modello, String targa, Integer cc) {
		super(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello);
		this.targa = targa;
		this.cc = cc;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Moto [Id = " + getId() + ", Numero ruote = "+ getNumeroRuote() +", Tipo alimentazione = " + getTipoAlimentazione() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Anno produzione = " + getAnnoProduzione()
				+ ", Targa =  "+getTarga() +", Cilindrata = " + getCc()+ "]";
	}
}
