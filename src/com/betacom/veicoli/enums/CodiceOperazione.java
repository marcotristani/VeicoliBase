package com.betacom.veicoli.enums;

public enum CodiceOperazione {

	ADD,
	LIST, 
	UNKNOWN;
	
	public static CodiceOperazione identificaCodice(String codiceStringa) {
		try {
			 return CodiceOperazione.valueOf(codiceStringa.trim().toUpperCase());
		} catch (Exception e) {
			return UNKNOWN;
		}
	}
}
