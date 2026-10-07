package com.betacom.veicoli;


import java.util.List;

import com.betacom.veicoli.process.StartVeicolo;
import com.betacom.veicoli.utilities.Utilities;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MainVeicoli {
	

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