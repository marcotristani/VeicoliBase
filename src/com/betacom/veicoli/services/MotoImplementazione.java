package com.betacom.veicoli.services;


import java.util.Map;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Moto;
import com.betacom.veicoli.singleton.SingleTon;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MotoImplementazione extends VeicoliMotoreAbstract{

	//private static List<String> paramSpecificiMoto = List.of("targa", "cc");


	@Override
	public void addToList(Map<String, String> map) {
		try {
			Moto nuovaMoto =controlParamsMoto(map);
	        SingleTon.getInstance().addListVeicoli(nuovaMoto);
	        log.debug("Aggiungo oggetto a lista. Tipo veicolo : " + nuovaMoto);
		} catch (Exception e) {
			throw new AcademyException("Impossibile caricare veicolo :" +map.toString() +"\n" + e.getMessage());
		}
		
	}
	
	
	public Moto controlParamsMoto(Map<String, String> paramsMoto) {
		super.controlVeicoloMotoreBase(paramsMoto);
		
		super.verifyRangeRuote(Integer.parseInt(paramsMoto.get("ruote")), 2, 4);


    	Moto moto =Moto.builder()
   			 .id(SingleTon.getInstance().incrementId())
   			 .tipoAlimentazione(paramsMoto.get("alim"))
   			 .categoria(paramsMoto.get("cat"))
   			 .colore(paramsMoto.get("colore"))
   			 .marca(paramsMoto.get("marca"))
   			 .modello(paramsMoto.get("modello"))
   			 .annoProduzione(Integer.parseInt(paramsMoto.get("anno")))
                .numeroRuote(Integer.parseInt(paramsMoto.get("ruote")))
   	         .targa(paramsMoto.get("targa"))
   	         .cc(Integer.parseInt(paramsMoto.get("cc")))
   	         .build();
		
    	return moto;
	}

	
}
