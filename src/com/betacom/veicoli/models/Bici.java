package com.betacom.veicoli.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Bici extends Veicoli{

	private Integer marce;
	private Integer corone;
	private String freno;
	private String sospensione;
	private Boolean pieghevole;
	

	
	@Override
	public String toString() {
		return "Bici [Id = " + getId() +", Numero ruote = "+ getNumeroRuote() + ", Tipo alimentazione = " + getAlim() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Anno produzione = " + getAnno()
				+ ", Numero marce =  "+getMarce() +", Numero corone = " + getCorone()+", Tipo freno = " + getFreno() + ", Tipo Sospensioni = " + getSospensione()+ ",Pieghevole = "+ (getPieghevole() ? "si" : "no") + " ]";
	}
	
	
}
