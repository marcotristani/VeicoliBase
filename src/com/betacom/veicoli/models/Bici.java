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

	private Integer numeroMarce;
	private Integer numeroCorone;
	private String tipoFreno;
	private String tipoSospensione;
	private Boolean pieghevole;
	

	
	@Override
	public String toString() {
		return "Bici [Id = " + getId() +", Numero ruote = "+ getNumeroRuote() + ", Tipo alimentazione = " + getTipoAlimentazione() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Anno produzione = " + getAnnoProduzione()
				+ ", Numero marce =  "+getNumeroMarce() +", Numero corone = " + getNumeroCorone()+", Tipo freno = " + getTipoFreno() + ", Tipo Sospensioni = " + getTipoSospensione()+ ",Pieghevole = "+ (getPieghevole() ? "si" : "no") + " ]";
	}
	
	
}
