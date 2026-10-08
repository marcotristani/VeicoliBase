package com.betacom.veicoli.services;

import java.util.List;
import java.util.Map;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;




public abstract class VeicoloAbstract{
	
	public static final List<String> PARAMETRI_COMUNI = List.of("ruote", "alim", "cat", "colore", "marca", "modello", "anno");

	public void addToList(Map<String, String> paramsVeicolo) {
		
	}
	
	public void controlVeicoloBase(Map<String, String> paramsVeicolo) {
		
		//Verifico se i parametri sono stati inseriti
			PARAMETRI_COMUNI.forEach(param -> {
				if(!paramsVeicolo.containsKey(param))
					throw new AcademyException("parametro " + param + " non inserito");
			}
			);

		//verifico i parametri numerici se sono veramente numeri
	    	new Utilities().verifyConversionStringToInt(paramsVeicolo.get("ruote"));
	    	new Utilities().verifyConversionStringToInt(paramsVeicolo.get("anno"));

	    //verifico se i valori dei parametri che devono appartenere ad una lista siano giusti
			verificaTipo("alim",paramsVeicolo.get("alim"));
			verificaTipo("cat",paramsVeicolo.get("cat"));

		//verifico se l'anno non sia futuro o troppo passato
	    	new Utilities().verifyAnnoPassato(paramsVeicolo.get("anno"));
	    	new Utilities().verifyAnnoFuturo(paramsVeicolo.get("anno"));
		
			
	}
	
	public void verificaAlimentazione(String alimentazione) {
		Boolean verify = SingleTon.getInstance().accettaAlimentazione(alimentazione);
		if (!verify) {
			throw new AcademyException("Alimentazione non accettata :" + alimentazione);
		}
	}
	
	public void verificaTipo(String tipo, String categoria) {
		Boolean verify = SingleTon.getInstance().accettaTipo(tipo, categoria);
		if (!verify) {
			throw new AcademyException("Categoria non accettata :" + categoria);
		}
	}
	
	
	public void verifyRangeRuote(Integer numeroRuote, Integer min, Integer max) {
		if(!(numeroRuote>= min && numeroRuote<=max))
			throw new AcademyException("Numero ruote non accettato per questo veicolo. Deve essere compreso tra "+ min + " e " + max);
	}

}
