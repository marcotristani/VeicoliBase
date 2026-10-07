package com.betacom.veicoli.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Veicoli {

	private Integer id;               //id univoco dell'oggetto
	private String tipo;       //macchina, moto, bici
	private Integer numeroRuote;      //dipende dal tipo veicolo
	private String alim; //benzina, diesel, elettrica, gpl, ibrida, manuale,metano
	private String categoria;         // strada, fuoristrada, suv, motocross.....
	private String colore;
	private String marca;             //fiat,bmw.....
	private Integer anno;
	private String modello;           //
	

}
