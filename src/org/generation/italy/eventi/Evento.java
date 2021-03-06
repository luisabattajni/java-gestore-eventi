package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	
	
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
			throw new Exception("Il numero dei posti totali non può essere un numero negativo.");
		}
		this.titolo = titolo;
		if (data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Questa data è già passata.");

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

	public int prenota() throws Exception {
		if (data.isAfter(LocalDate.now()) && postiPrenotati < postiTot) {
			return ++postiPrenotati;
		} else if (postiPrenotati > postiTot) {
			throw new Exception("Non ci sono così tanti posti disponibili.");
		} else {
			throw new Exception("Questa data è già passata.");
		}

	}
	public int prenota(int n) throws Exception {
		if (data.isAfter(LocalDate.now()) && (n + postiPrenotati) < postiTot) {
				postiPrenotati = postiPrenotati + n;
				return postiPrenotati;
			} else if (n > postiTot) {
			throw new Exception("Non ci sono così tanti posti disponibili.");
		} else {
			throw new Exception("Questa data è già passata.");
		}
	}
	


	public int disdici() throws Exception {
		if (data.isAfter(LocalDate.now()) && postiPrenotati == 0) {
			return --postiPrenotati;
		} else if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni.");
		} else {
			throw new Exception("Questa data è già passata.");
		}
	
	}
	
	public int disdici(int n) throws Exception {
		if (data.isAfter(LocalDate.now()) && postiPrenotati > 0) {
			postiPrenotati = postiPrenotati -  n;
			return postiPrenotati;
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
