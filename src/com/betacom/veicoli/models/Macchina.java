package com.betacom.veicoli.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Macchina extends Veicoli {

	private String targa;         //deve essere univoca
	private Integer cc;           //cilindrata
	private Integer porte;
	


	@Override
	public String toString() {
		return "Macchina [Id = " + getId() + ", Numero ruote = "+ getNumeroRuote() +", Tipo alimentazione = " + getAlim() + ", Categoria = " + getCategoria() + ", Colore = " + getColore()
				+ ", Marca = " + getMarca() +", Modello =  " + getModello() + ", Numero porte = " + getPorte() + ", Anno produzione = " + getAnno()
				+ ", Targa =  "+getTarga() +", Cilindrata = " + getCc()+ "]";
	}
	
}
