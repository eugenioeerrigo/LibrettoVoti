package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Chimica", 28));
		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica", 18));
		
		//lib.stampa();                                      sostituisco con quello sotto
		//System.out.println(lib.toString());
		
		System.out.println("Voti uguali a 25: ");
		lib.stampa25();
		
		System.out.println("Voto TdP: ");
		System.out.println(lib.getMarkfromClass("TdP"));
		System.out.println("Voto tdp (minuscolo): ");
		System.out.println(lib.getMarkfromClass("tdp"));
		
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("TdP", 27));
		
		System.out.println(lib.toString());
		
		Libretto newLib = new Libretto(lib.getVoti());   //nuovo costruttore
		
		newLib.alzaVoti();

		System.out.println("\nNuovo libretto");
		System.out.println(newLib.toString());
		
		Collections.sort(newLib.getVoti());
		
		System.out.println("\nNuovo libretto ordinato");
		System.out.println(newLib.toString());
		
		Collections.sort(newLib.getVoti(), new Comparator<Voto>(){
			
			public int compare(Voto o1, Voto o2) {
				return -(o1.getVoto()-o2.getVoto());
			}
			
		});
		
		System.out.println("\nNuovo libretto ordinato voti decrescenti");
		System.out.println(newLib.toString());
	}

}
