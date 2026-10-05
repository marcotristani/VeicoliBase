package com.betacom.veicoli.models;

public class Macchina extends Veicoli {

	public Macchina(String tipoVeicolo,Integer numeroRuote, String tipoAlimentazione, String categoria, String colore,
			String marca, Integer annoProduzione, String modello, String targa, Integer cc, Integer numeroPorte) {
		
		super(tipoVeicolo, numeroRuote, tipoAlimentazione, categoria, colore, marca, annoProduzione, modello);
		this.targa = targa;
		this.cc = cc;
		this.numeroPorte = numeroPorte;
	}
	private String targa;         //deve essere univoca
	private Integer cc;           //cilindrata
	private Integer numeroPorte;
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}

	@Override
	public String toString() {
		return "Macchina [Id = " + getId() + ", Numero ruote = "+ getNumeroRuote() +", Tipo alimentazione = " + getTipoAlimentazione() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Numero porte = " + getNumeroPorte() + ", Anno produzione = " + getAnnoProduzione()
				+ ", Targa =  "+getTarga() +", Cilindrata = " + getCc()+ "]";
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public Integer getNumeroPorte() {
		return numeroPorte;
	}
	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}
}
