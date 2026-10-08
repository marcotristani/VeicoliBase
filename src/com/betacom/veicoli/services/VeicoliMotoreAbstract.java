package com.betacom.veicoli.services;

import java.util.List;
import java.util.Map;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;

public abstract class VeicoliMotoreAbstract extends VeicoloAbstract{

	public static final List<String> parametriVeicoliMotore = List.of("targa", "cc");
	
	private static final String REGEX_TARGA = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$";

	public void addToList(Map<String, String> paramsVeicolo) {
		
	}
	
	public void controlVeicoloMotoreBase(Map<String, String> paramsVeicoloMotore) {
		
		super.controlVeicoloBase(paramsVeicoloMotore);
		//Verifico se i parametri sono stati inseriti
		for(String param : parametriVeicoliMotore) {
			if(!paramsVeicoloMotore.containsKey(param))
				throw new AcademyException("parametro " + param + " non inserito");
		}

    	verificaTarga(paramsVeicoloMotore.get("targa"));
    	new Utilities().verifyConversionStringToInt(paramsVeicoloMotore.get("cc"));
		
			
	}

	public static void verificaTarga(String targa) {
		if(!targa.toUpperCase().matches(REGEX_TARGA)) {
			throw new AcademyException("Formato targa non valido :" + targa);
			}
		if (!SingleTon.getInstance().accettaTarga(targa.toUpperCase())) {
			throw new AcademyException("Targa già presente :" + targa);
		}
	}
}

