package com.betacom.veicoli.services;

import java.util.List;
import java.util.Map;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;

public abstract class VeicoliMotoreAbstract extends VeicoloAbstract{

	public static final List<String> parametriVeicoliMotore = List.of("targa", "cc");

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

	public void verificaTarga(String Targa) {
		Boolean verify = SingleTon.getInstance().accettaTarga(Targa);
		if (!verify) {
			throw new AcademyException("Targa già presente :" + Targa);
		}
	}
}

