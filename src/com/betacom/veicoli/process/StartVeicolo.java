package com.betacom.veicoli.process;



import java.util.List;

import com.betacom.veicoli.enums.CodiceOperazione;
import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.services.ListImplementazione;
import com.betacom.veicoli.singleton.SingleTon;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class StartVeicolo {
	//private static final Logger log = LoggerFactory.getLogger(StartVeicolo.class);

	private static final int POSIZIONECODICEOPERAZIONE = 0;

	public void execute(List<String> input) throws Exception{
		log.info("Begin StartVeicolo");
		
		for(String item : input) {
			String[] params= item.split(",");
			CodiceOperazione codiceOperazione = CodiceOperazione.identificaCodice(params[POSIZIONECODICEOPERAZIONE]);
			
			switch (codiceOperazione) {
			case ADD ->{
				try {
			    	new ListImplementazione().add(params);
				} catch (Exception e) {
					log.error("Error found :" + e.getMessage() );
				}
				
			}
			case LIST -> new ListImplementazione().printVeicoli(SingleTon.getInstance().getListVeicoli());
		
			case UNKNOWN ->{
				try{
					throw new AcademyException("Codice operazione inesistente -> " + params[POSIZIONECODICEOPERAZIONE]);
				}catch (Exception e) {
					log.error("Error :" +e.getMessage());
				}
			}
		
			}
		}

	}
}
