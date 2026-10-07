package com.betacom.veicoli.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Veicoli;


public class Utilities {

	private static final Logger log = LoggerFactory.getLogger(Utilities.class);

	
	public void verifyConversionStringToInt(String stringa) {
		try {
			Integer.parseInt(stringa);
		} catch (Exception e) {
			throw new AcademyException("Valore numerico errato : \n" + e.getMessage());
		}
	}
	
	public void verifyAnnoFuturo(String annoStringa) {
			if(!(Integer.parseInt(annoStringa)<= Year.now().getValue()))
				throw new AcademyException("Anno inserito non valido: anno inserito superiore all'anno corrente");
	}
	
	public void verifyAnnoPassato(String annoStringa) {
		if(Integer.parseInt(annoStringa)<= (Year.now().getValue() - 20))
			throw new AcademyException("Anno inserito non valido: anno inserito inferiore alla soglia di 20 anni fa");
	}

	public List<String> readToFile(String path){
		List<String> result = new ArrayList<String>();

		//questo tipo di try ci permettde di leggere un file e far gestire da java l'apertura e chiusura
	
		try (BufferedReader reader= new BufferedReader(new FileReader(path))){
		String line = reader.readLine();
		
		while(line != null) {
			result.add(line);
			line =reader.readLine();
		}	
	    
		} catch (Exception e) {
		log.error(e.getMessage());
		}
	
		return result;
	}
	
	public int writeFile(String path, List<Veicoli> input,boolean mode) {

			//faccio ritornare il numero di righe scritte
			int num = 0;
			
			//scrivo il file
			try (FileWriter output = new FileWriter(path, mode)){
				
				output.write("----------LISTA VEICOLI------------\n");

				for(Veicoli record : input) {
					output.write((input.indexOf(record) + 1) + ") ");

					output.write(record.toString());
					output.write("\n"); //metto questa stringa per andare a capo a ogni riga
					num++;
				}
				
				output.write("\n----------FINE LISTA VEICOLI------------");

			} catch (Exception e) {
				e.printStackTrace();
			}
			

			return num;
		
	}
	public static boolean isPieghevole(String pieghevole) {
		
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
	
	public static String buildClassName(String param) {
		return param.substring(0 , 1).toUpperCase()+param.substring(1).toLowerCase()+"Implementazione";
	}
	
}
