package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// formattazione per dopo
public class Evento {
	

	//@prof se dimentico di cancellare i commenti per l'ultimo push prego ignorare 
	
	
	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTot;
	private int postiPrenotati;

	//costruttori
	public Evento (String titolo, LocalDate data, int postiTot)  throws Exception {
		if (postiTot > 0) {
			this.postiTot = postiTot;
		} else {
			//errore
			throw new Exception("Il numero dei posti totali non può essere un numero negativo.");
		}
		this.titolo = titolo;
		//quindi tipo if data >= data now thisdata= data else throw error
		//check support link biglietto?
		this.data = data;
		if (data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			//errore
			throw new Exception("Questa data è già passata.");
			//se/quando chiamo chiedere se devo fare un caso per equals/per il giorno stesso
			//ma credo conti come passato?
		}
		this.postiPrenotati = 0;	
	}
	
	//getter & setter

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getPostiTot() {
		return postiTot;
	}
	
	//metodi public


	
	//okay avevo letto male la consegna rip, posso effettivamente metter boolean isValid 
	//dato che l'ho visto solo ora correggo dopo
	
//	private boolean isValidData(LocalDate data) {
//		return data.isAfter(LocalDate.now());
//	}
	

	//prova? da controllare
	public int prenota () throws Exception {
		if (data.isAfter(LocalDate.now()) && postiPrenotati <= postiTot) {
			return postiPrenotati + 1;
		} else if (postiPrenotati > postiTot) {
			throw new Exception("Non ci sono così tanti posti disponibili.");
		} else {
			throw new Exception("Questa data è già passata.");
		}

	}


	public int disdici () throws Exception {
		if (data.isAfter(LocalDate.now()) && postiPrenotati == 0) {
			return postiPrenotati - 1;
		} else if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni.");
		} else {
			throw new Exception("Questa data è già passata.");
		}

		
	}

	
	//override data formattata - titolo
	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = data.format(df);
		return dataFormattata + " - " + titolo;
	}


	

}
