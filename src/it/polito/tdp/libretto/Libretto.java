package it.polito.tdp.libretto;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		voti = new ArrayList<>(); //uso type inference <> (inferenza automatica del tipo)
	}
	
	public Libretto(List<Voto> voti) {
		//this.voti=voti;                             //uso la stessa lista, non la duplico mantenendo le modifiche separate (Shallow Copy)
		//this.voti= new ArrayList<Voto>(voti);         //Deep copy - ho due liste diverse e due puntatori, ma gli oggetti sono uguali, non sono stati duplicati
		
		this.voti = new ArrayList<Voto>();              //Soluzione corretta 
		for(Voto v: voti) 
			this.voti.add(new Voto(v.getEsame(), v.getVoto()));  //voti duplicati
	}
	
	public void add(Voto v) {
		if(this.voti.contains(v)) {                           //punto 4
			System.out.println("Il voto esiste gia'.\n");
			return;
		}
		for(Voto voto: voti) {                                //punto 5
			if(voto.getEsame().equals(v.getEsame())) {
				System.out.println("Ho trovato lo stesso esame (aggiorno voto).\n");
				voto.setVoto(v.getVoto());
				return;
			}
		}
		voti.add(v);
	}
	
	public List<Voto> getVoti(){
		return voti;
	}
	
	public void stampa() {            //oppure utilizzo override toString() (vedi sotto)
		System.out.println("Ci sono "+voti.size()+" voti.");
		for(Voto v : voti)
			System.out.println(v);
	}

	//punto 2
	public void stampa25() {    
		for(Voto v : voti) {
			if(v.getVoto()==25)
				System.out.println(v);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();        //al posto della concatenazione, perchè ogni chiamata di stringa ne crea una nuova
		sb.append("Ci sono "+voti.size()+" voti.\n");
		for(Voto v : voti) {
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
    
	//punto 3
	public String getMarkfromClass(String nomeCorso) {
		for(Voto v: this.voti) {
			if(v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase()))
				return String.valueOf(v.getVoto());
		}
		return "nomeCorso not found";
	}

	public void alzaVoti() {
		for(Voto v : voti) {
			if(v.getVoto()>=24)
				v.setVoto(v.getVoto()+2);
			else if(v.getVoto()>18)
				v.setVoto(v.getVoto()+1);
		}
	}
	
	
}
