package com.betacom.veicoli.services;

import java.util.Map;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;


public abstract class VeicoloAbstract{

	public void addToList(Map<String, String> paramsVeicolo) {
		
	}
	
	public void controlVeicoloBase(Map<String, String> paramsVeicolo) {
		if(!paramsVeicolo.containsKey("ruote"))
			throw new AcademyException("Numero ruote non caricato");
    	new Utilities().verifyConversionStringToInt(paramsVeicolo.get("ruote"));
		
		
		if(!paramsVeicolo.containsKey("alim"))
			throw new AcademyException("Tipo Alimentazione non caricata");
		verificaAlimentazione(paramsVeicolo.get("alim"));
	
		if(!paramsVeicolo.containsKey("cat"))
			throw new AcademyException("Categoria non caricato");
		
		verificaCategoria(paramsVeicolo.get("cat"));
		
		if(!paramsVeicolo.containsKey("colore"))
			throw new AcademyException("Colore non caricato");
		
		if(!paramsVeicolo.containsKey("marca"))
			throw new AcademyException("Marca non caricata");
	
		if(!paramsVeicolo.containsKey("modello"))
			throw new AcademyException("Modello non caricato");
	
		if(!paramsVeicolo.containsKey("anno"))
			throw new AcademyException("Anno di produzione non caricato");
    	new Utilities().verifyConversionStringToInt(paramsVeicolo.get("anno"));
    	new Utilities().verifyAnnoPassato(paramsVeicolo.get("anno"));
    	new Utilities().verifyAnnoFuturo(paramsVeicolo.get("anno"));
	}
	
	public void verificaAlimentazione(String alimentazione) {
		Boolean verify = SingleTon.getInstance().accettaAlimentazione(alimentazione);
		if (!verify) {
			throw new AcademyException("Alimentazione non accettata :" + alimentazione);
		}
	}
	
	public void verificaCategoria(String categoria) {
		Boolean verify = SingleTon.getInstance().accettaCategoria(categoria);
		if (!verify) {
			throw new AcademyException("Categoria non accettata :" + categoria);
		}
	}
	
	public void verificaTarga(String Targa) {
		Boolean verify = SingleTon.getInstance().accettaTarga(Targa);
		if (!verify) {
			throw new AcademyException("Targa già presente :" + Targa);
		}
	}
	
	public void verifyRangeRuote(Integer numeroRuote, Integer min, Integer max) {
		if(!(numeroRuote>= min && numeroRuote<=max))
			throw new AcademyException("Numero ruote non accettato per questo veicolo. Deve essere compreso tra "+ min + " e " + max);
	}

}
