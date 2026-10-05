package com.betacom.veicoli.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Moto;
//import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;

public class MotoImplementazione extends VeicoloAbstract{

	private static final Logger log = LoggerFactory.getLogger(MotoImplementazione.class);

	@Override
	public void addToList(Map<String, String> map) {
		try {
			controlParamsMoto(map);
			Moto nuovaMoto = new Moto(map.get("tipo"),Integer.parseInt(map.get("ruote")), map.get("alim"), map.get("cat"), map.get("colore"), map.get("marca"),Integer.parseInt(map.get("anno")), map.get("modello"), map.get("targa"), Integer.parseInt(map.get("cc")));
	        SingleTon.getInstance().addListVeicoli(nuovaMoto);
	        log.debug("Aggiungo oggetto a lista. Tipo veicolo : " + nuovaMoto);
		} catch (Exception e) {
			throw new AcademyException("Impossibile caricare veicolo :" +map.toString() +"\n" + e.getMessage());
		}
		
	}
	
	
	public void controlParamsMoto(Map<String, String> paramsMoto) {
		super.controlVeicoloBase(paramsMoto);
		
		super.verifyRangeRuote(Integer.parseInt(paramsMoto.get("ruote")), 2, 4);


		if(!paramsMoto.containsKey("targa"))
			throw new AcademyException("Targa non caricato");
    	super.verificaTarga(paramsMoto.get("targa"));
    	
    	if(!paramsMoto.containsKey("cc"))
			throw new AcademyException("Cilindrata non caricata");
    	new Utilities().verifyConversionStringToInt(paramsMoto.get("cc"));

		
	}

	
}
