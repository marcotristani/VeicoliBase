package com.betacom.veicoli.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Bici;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;

public class BiciImplementazione extends VeicoloAbstract{
	
	private static final Logger log = LoggerFactory.getLogger(BiciImplementazione.class);


	@Override
	public void addToList(Map<String, String> map) {
		try {
			controlParamsBici(map);
			Bici nuovaBici = new Bici(map.get("tipo"), Integer.parseInt(map.get("ruote")),map.get("alim"), map.get("cat"), map.get("colore"), map.get("marca"),Integer.parseInt(map.get("anno")), map.get("modello"), Integer.parseInt(map.get("marce")) ,Integer.parseInt(map.get("corone")) ,map.get("freno"),map.get("sospensione"),isPieghevole(map.get("pieghevole")));
			
	        SingleTon.getInstance().addListVeicoli(nuovaBici);
	        log.debug("Aggiungo oggetto a lista. Tipo veicolo : " + nuovaBici);
		} catch (Exception e) {
			throw new AcademyException("Impossibile caricare veicolo :" +map.toString()+"\n" + e.getMessage());
		}
		
	}
	
	
	public void controlParamsBici(Map<String, String> paramsBici) {
		super.controlVeicoloBase(paramsBici);
		super.verifyRangeRuote(Integer.parseInt(paramsBici.get("ruote")), 1, 6);

		
		if(!paramsBici.containsKey("marce"))
			throw new AcademyException("Numero Marce  non caricato");
    	new Utilities().verifyConversionStringToInt(paramsBici.get("marce"));
    	
    	if(!paramsBici.containsKey("corone"))
			throw new AcademyException("Numero Corone  non caricato");
    	new Utilities().verifyConversionStringToInt(paramsBici.get("corone"));
    	
    	if(!paramsBici.containsKey("freno"))
			throw new AcademyException("Tipo Freno  non caricato");
    	
    	if(!paramsBici.containsKey("sospensione"))
			throw new AcademyException("Tipo Sospensione  non caricato");
	}
	
	private boolean isPieghevole(String pieghevole) {
		
		Map<String, Boolean> yesOrNot = new HashMap<String, Boolean>();
		yesOrNot.put("si", true);
		yesOrNot.put("no", false);
		if(pieghevole != null) {
		for(String item:yesOrNot.keySet()) {
			if(pieghevole.equals(item))
				return yesOrNot.get(item);
		}
		throw new AcademyException("Valore pieghevole non valido: inserire 'si' o 'no'");
		}else {
			System.err.println("Valore pieghevole non inserito, settato a falso");
			return false;
		}
	}
	
}
