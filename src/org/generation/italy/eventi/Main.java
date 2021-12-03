package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;
//import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int postiPrenotati = 0;

		// lato organizzativo

		System.out.println("Inserite il titolo dell'evento che desiderate organizzare: ");
		String titolo = scan.nextLine();
		// sposto un attimo sopra i posti, finché non risolvo data
		System.out.println("Inserite il numero totale dei posti: ");
		int postiTot = scan.nextInt();

		// LocalDate???

//		System.out.println("Inserite la data (dd/MM/yyyy): ");
		System.out.println("giorno: ");
		int dd = scan.nextInt();
		System.out.println("mese: ");
		int mm = scan.nextInt();
		System.out.println("anno: ");
		int yyyy = scan.nextInt();
		LocalDate data = LocalDate.of(yyyy, mm, dd);
//		System.out.println("Data: " + data);
		// debug

		// lato utente
		scan.nextLine();

		try {
			Evento evento = new Evento(titolo, data, postiTot);

//		boolean vuoiPrenotare = true;
//		boolean errore = false;

			System.out.println("Si desidera effettuare una prenotazione? s/n: ");
			String continua = scan.nextLine();

			if (continua.equals("s")) {
				// continua chiedendo quanti posti
				System.out.println("Quanti posti si desidera prenotare? ");
				int postiAgg = scan.nextInt();
				System.out.println(evento.prenota(postiAgg));
				postiPrenotati = evento.prenota(postiAgg);
				System.out.println("Numero di posti prenotati: " + postiPrenotati);
				int postiDisponili = postiTot - postiPrenotati;
				System.out.println("Numero di posti disponibili: " + postiDisponili);

			} else if (continua.equals("n")) {
				System.out.println("Operazione terminata");
			} else {
				System.out.println("Prego utilizzare unicamente (s/n)");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//		System.out.println("Numero di posti prenotati: " + postiPrenotati);
//		//non mi parte l'errore che dovrebbe dare se chiedo più posti del tot
//		int postiDisponili = postiTot - postiPrenotati;
//		System.out.println("Numero di posti disponibili: " + postiDisponili);
		
		
		scan.nextLine();
//		// disdette
		try {
			Evento evento = new Evento(titolo, data, postiTot);
			System.out.println("Si desidera disdire prenotazione? s/n: ");
			String cancel = scan.nextLine();

			if (cancel.equals("s")) {
				System.out.println("Quanti posti si desidera disdire? ");
				int disd = scan.nextInt();
				if (disd <= postiPrenotati) {
					System.out.println(evento.disdici(disd));
					postiPrenotati = postiPrenotati + evento.disdici(disd);
					System.out.println("Numero di posti prenotati: " + postiPrenotati);
					int postiDisponili = postiTot - postiPrenotati;
					System.out.println("Numero di posti disponibili: " + postiDisponili);
				} else {
					System.out.println("Non hai prenotato così tanti posti");
					}
			} else if (cancel.equals("n")) {
				System.out.println("Operazione terminata");
			} else {
				System.out.println("Prego utilizzare unicamente (s/n)");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		scan.close();
	}

}
