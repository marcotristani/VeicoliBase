package com.betacom.veicoli;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.veicoli.process.StartVeicolo;
import com.betacom.veicoli.utilities.Utilities;


public class MainVeicoli {
	
	private static final Logger log = LoggerFactory.getLogger(MainVeicoli.class);

	public static void main(String[] args) {
		List<String> param = new Utilities().readToFile("C:\\Users\\ACER\\Desktop\\Academy java betacom\\progetti eclipse\\fileSystemProve\\paramsVeicoli.txt");


		log.info("Start Veicoli");
		
		
		try {
			new StartVeicolo().execute(param);
		}catch (Exception e) {
			System.err.println("Error found in process" + e.getMessage());
		}


}
}