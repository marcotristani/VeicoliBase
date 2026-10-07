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
public class Moto extends Veicoli{

	private String targa;
	private Integer cc;
	
	@Override
	public String toString() {
		return "Moto [Id = " + getId() + ", Numero ruote = "+ getNumeroRuote() +", Tipo alimentazione = " + getTipoAlimentazione() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Anno produzione = " + getAnnoProduzione()
				+ ", Targa =  "+getTarga() +", Cilindrata = " + getCc()+ "]";
	}
}
