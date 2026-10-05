package com.betacom.veicoli.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.utilities.Utilities;

public class ListImplementazione {
	
	private static final Logger log = LoggerFactory.getLogger(ListImplementazione.class);

	private static final int POSIZIONETIPOVEICOLO = 1;
	public void add(String[] paramsVeicolo) {
		
		Map<String, VeicoloAbstract> mapTipoVeicolo = new HashMap<String, VeicoloAbstract>();
		mapTipoVeicolo.put("macchina", new MacchinaImplementazione());
		mapTipoVeicolo.put("moto", new MotoImplementazione());
		mapTipoVeicolo.put("bici",new BiciImplementazione());
		
			Map<String, String> map = new HashMap<String, String>();
			map.put("tipo",paramsVeicolo[POSIZIONETIPOVEICOLO]);
		    for(int i = POSIZIONETIPOVEICOLO + 1; i<paramsVeicolo.length; i++) {
			    String[] element = paramsVeicolo[i].split("=");
			    map.put(element[0].trim(), element[1].trim());
		    }

		    if(mapTipoVeicolo.containsKey(map.get("tipo"))) {
		    	VeicoloAbstract veicolo = mapTipoVeicolo.get(map.get("tipo"));
		    	veicolo.addToList(map);
		    }else {
		    	throw new AcademyException("Impossibile caricare veicolo :" + map.toString() +"\nTipo Veicolo Inesistente : " + map.get("tipo") );
		    }
		   
		}
	
	public void printVeicoli(List<Veicoli> veicoli) {
		log.info("STAMPO LISTA VEICOLI INSERITI -"+  veicoli.size() + " veicoli presenti nella lista ");
		/*for(Veicoli item : veicoli) {
			System.out.println((veicoli.indexOf(item ) + 1) + ") " + item.toString());
		}*/
		new Utilities().writeFile("C:\\Users\\ACER\\Desktop\\Academy java betacom\\progetti eclipse\\fileSystemProve\\listaVeicoli.txt", veicoli, false);

	}
	
}
