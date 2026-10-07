package com.betacom.veicoli.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.betacom.veicoli.models.Veicoli;

public class SingleTon {

	private static SingleTon instance = null;
	
	private Integer id = 0;
	private List<Veicoli> listVeicoli = new ArrayList<Veicoli>();
	private List<String> listTarghe = new ArrayList<String>();
		
	private List<String> listAlim = List.of("benzina","diesel","manuale","gpl","hybrid","metano");
	private List<String> listCategorie = List.of("strada","fuoristrada","pista");
	
	private Map<String, List<String>> listeTipiAccettati =  Map.of("alim", listAlim, "cat", listCategorie);
	
	
	private SingleTon() {
	}

	public static SingleTon getInstance() {
		if(instance == null) {
			instance = new SingleTon();
		}
		return instance;
	}
	
	public Integer incrementId() {
		return ++id;
	}
	
	public void addListVeicoli(Veicoli veicolo){
		listVeicoli.add(veicolo);
		
	}
	
	public List<Veicoli> getListVeicoli(){
		return listVeicoli;
	}
	
	public boolean accettaTarga(String Targa) {
		if(listTarghe.contains(Targa)) {
			return false;
		}else {
			listTarghe.add(Targa);
			return true;
		}
		
	}
	
	public boolean accettaCategoria(String categoria) {
		return listCategorie.contains(categoria);
	}
	
	public boolean accettaAlimentazione(String alimentazione) {
		return listAlim.contains(alimentazione); 
	}
	
	public boolean accettaTipo(String tipo, String daVerificare) {
		return listeTipiAccettati.get(tipo).contains(daVerificare);
	}
	
	
	
}
