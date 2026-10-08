package com.betacom.veicoli.services;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.betacom.veicoli.exception.AcademyException;
import com.betacom.veicoli.models.Veicoli;
import com.betacom.veicoli.utilities.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListImplementazione {
	
	private static final String PATH_PROCESS = "com.betacom.veicoli.services";


	private static final int POSIZIONETIPOVEICOLO = 1;
	public void add(String[] paramsVeicolo) {
		

		Map<String, String> map = new HashMap<String, String>();
			map.put("tipo",paramsVeicolo[POSIZIONETIPOVEICOLO]);
		    for(int i = POSIZIONETIPOVEICOLO + 1; i<paramsVeicolo.length; i++) {
			    String[] element = paramsVeicolo[i].split("=");
			    map.put(element[0].trim().toLowerCase(), element[1].trim().toLowerCase());
		    }


			try {
				VeicoloAbstract add = (VeicoloAbstract) loadImplementazione(map.get("tipo"));
				addToListOperation(add, map);

			} catch (Exception e) {
				log.error("error found {}", e.getMessage());
			}
		   
		}


	
	private static Object loadImplementazione(String nameImplementazione) throws Exception{
		try {
			Class<?> cl = Class.forName(PATH_PROCESS + "." + Utilities.buildClassName(nameImplementazione) ) ;
			Object obj = cl.getDeclaredConstructor().newInstance();
			return obj;
			
		} catch (ClassNotFoundException e) {
			throw new AcademyException("Implementazione non previsto -> " + Utilities.buildClassName(nameImplementazione));
		}
	}
	
	private static void addToListOperation(VeicoloAbstract myImplementazione,Map<String, String> map) throws Exception{
		try {
			
			Method metodo = myImplementazione.getClass().getMethod("addToList", Map.class);
			metodo.invoke(myImplementazione,map);
			
		} catch (SecurityException e) {
			throw new AcademyException("errore di sicurezza : "+ e.getMessage());
		}
		 catch (IllegalAccessException e) {
				throw new AcademyException("errore di illegal access : "+ e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new AcademyException("errore di illegal argument  : "+ e.getMessage());
		}
		 catch (InvocationTargetException e) {
				throw new AcademyException("errore di invocazione metodo della classe : "+ e.getCause().getMessage());
		}
		 catch (NoSuchMethodException e) {
				throw new AcademyException("metodo non trovato : "+ e.getMessage());
		}
	}
	
	
	
	public void printVeicoli(List<Veicoli> veicoli) {
		log.info("STAMPO LISTA VEICOLI INSERITI -"+  veicoli.size() + " veicoli presenti nella lista ");
		new Utilities().writeFile("C:\\Users\\ACER\\Desktop\\Academy java betacom\\progetti eclipse\\fileSystemProve\\listaVeicoli.txt", veicoli, false);

	}
	
	public void printVeicoli(List<Veicoli> veicoli, String[] paramsFilter) {
		Map<String, String> mapFiltri = new HashMap<String, String>();
	    for(int i = 1; i<paramsFilter.length; i++) {
		    String[] element = paramsFilter[i].split("=");
		    mapFiltri.put(element[0].trim().toLowerCase(), element[1].trim().toLowerCase());
	    }
	    
	    List<Veicoli> listaVeicoliFiltrata = veicoli;
		for(String item:mapFiltri.keySet()) {
			 listaVeicoliFiltrata = filtraListaDinamica(listaVeicoliFiltrata, item.trim().toLowerCase(), mapFiltri.get(item).trim().toLowerCase());

		}
		//List<Veicoli> listaVeicoliFiltrata = filtraListaDinamica(veicoli, filtro[0].trim().toLowerCase(), filtro[1].trim().toLowerCase());
		printVeicoli(listaVeicoliFiltrata);

	}
	
	/*
	public List<Veicoli> filtraMarca (List<Veicoli> lista, String valoreMarca){
		return lista.stream().filter(param -> param.getMarca().equals(valoreMarca)).collect(Collectors.toList());
	}
	
	public List<Veicoli> filtraModello (List<Veicoli> lista, String valoreModello){
		return lista.stream().filter(param -> param.getModello().equals(valoreModello)).collect(Collectors.toList());
	}
	public List<Veicoli> filtraColore (List<Veicoli> lista, String valoreColore){
		return lista.stream().filter(param -> param.getColore().equals(valoreColore)).collect(Collectors.toList());
	}
	public List<Veicoli> filtraTipo (List<Veicoli> lista, String valoreTipo){
		return lista.stream().filter(param -> param.getTipo().equals(valoreTipo)).collect(Collectors.toList());
	}
	public List<Veicoli> filtraCategoria (List<Veicoli> lista, String valoreCategoria){
		return lista.stream().filter(param -> param.getModello().equals(valoreCategoria)).collect(Collectors.toList());
	}
	*/
	
	
	
	public List<Veicoli> filtraListaDinamica(List<Veicoli> lista, String nomeAttributo, String valoreDaCercare) {
		
	    String nomeGetter = "get" + nomeAttributo.substring(0, 1).toUpperCase() + nomeAttributo.substring(1);

	    return lista.stream()
	            .filter(veicolo -> {
	        
	                // PRENDO LA CLASSE REALE DELL'OGGETTO CORRENTE 
	                Class<?> classeVeicoloCorrente = veicolo.getClass();

	                try {
	                    // Cerchiamo il metodo get specifico sulla classe reale dell'oggetto
	                    Method getter = classeVeicoloCorrente.getMethod(nomeGetter);
	                    

	                    // Identifichiamo il tipo di ritorno specifico di questo oggetto
	                    Class<?> tipoOggettoGetter = getter.getReturnType();
	                    
	                    // Convertiamo la stringa nel tipo corretto (int, boolean, String)
	                    Object valoreConvertito = convertiStringa(valoreDaCercare, tipoOggettoGetter);

	                    // Invochiamo il getter e confrontiamo il valore
	                    Object valoreAttuale = getter.invoke(veicolo);

	                    return valoreConvertito.equals(valoreAttuale);

	                }  catch (SecurityException e) {
	        			throw new AcademyException("errore di sicurezza : "+ e.getMessage());
	        		}
	        		 catch (IllegalAccessException e) {
	        				throw new AcademyException("errore di illegal access : "+ e.getMessage());
	        		} catch (IllegalArgumentException e) {
	        			throw new AcademyException("errore di illegal argument  : "+ e.getMessage());
	        		}
	        		 catch (InvocationTargetException e) {
	        				throw new AcademyException("errore di invocazione metodo della classe : "+ e.getCause().getMessage());
	        		}
	        		 catch (NoSuchMethodException e) {
	        			 return false;
	        		}
	            })
	            .collect(Collectors.toList());
	}

	
	private Object convertiStringa(String valore, Class<?> tipoOggettoGetter) {

	    if (tipoOggettoGetter == Integer.class || tipoOggettoGetter == int.class) {
	        return Integer.parseInt(valore);
	    }

	    if (tipoOggettoGetter == Boolean.class || tipoOggettoGetter == boolean.class) {
	        return Utilities.isPieghevole(valore);
	    }

	    return valore; 
	}
}
