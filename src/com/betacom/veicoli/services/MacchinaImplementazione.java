package com.betacom.veicoli.services;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Macchina;
import com.betacom.veicoli.singleton.SingleTon;
import com.betacom.veicoli.utilities.Utilities;

public class MacchinaImplementazione extends VeicoloAbstract{
	
	private static final Logger log = LoggerFactory.getLogger(MacchinaImplementazione.class);


	@Override
public void addToList(Map<String, String> map) {
		try {
			controlParamsMacchina(map);
			Macchina nuovaMacchina = new Macchina(map.get("tipo"),Integer.parseInt(map.get("ruote")),map.get("alim"), map.get("cat"), map.get("colore"), map.get("marca"),Integer.parseInt(map.get("anno")), map.get("modello"), map.get("targa"), Integer.parseInt(map.get("cc")), Integer.parseInt(map.get("porte")));
	        SingleTon.getInstance().addListVeicoli(nuovaMacchina);
	        log.debug("Aggiungo oggetto a lista. Tipo veicolo : " + nuovaMacchina);
		} catch (Exception e) {
			throw new AcademyException("Impossibile caricare veicolo :" +map.toString() +"\n"+ e.getMessage());
		}
		
	}
	
	
	public void controlParamsMacchina(Map<String, String> paramsMacchina) {
		super.controlVeicoloBase(paramsMacchina);
		
		super.verifyRangeRuote(Integer.parseInt(paramsMacchina.get("ruote")), 4, 6);
		
		if(!paramsMacchina.containsKey("targa"))
			throw new AcademyException("Targa non caricato");
    	super.verificaTarga(paramsMacchina.get("targa"));
    	
    	if(!paramsMacchina.containsKey("cc"))
			throw new AcademyException("Cilindrata non caricata");
    	new Utilities().verifyConversionStringToInt(paramsMacchina.get("cc"));
    	
    	if(!paramsMacchina.containsKey("porte"))
			throw new AcademyException("Numero porte non caricato");
    	new Utilities().verifyConversionStringToInt(paramsMacchina.get("porte"));
		
	}
	
}
