package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;
//import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		

		// lato organizzativo

		System.out.println("Inserite il titolo dell'evento che desiderate organizzare: ");
		String titolo = scan.nextLine();

		System.out.println("Inserite il numero totale dei posti: ");
		int postiTot = scan.nextInt();

		System.out.println("giorno: ");
		int dd = scan.nextInt();
		System.out.println("mese: ");
		int mm = scan.nextInt();
		System.out.println("anno: ");
		int yyyy = scan.nextInt();
		LocalDate data = LocalDate.of(yyyy, mm, dd);


		// lato utente
		scan.nextLine();

		try {
			Evento evento = new Evento(titolo, data, postiTot);

			System.out.println("Si desidera effettuare una prenotazione? s/n: ");
			String continua = scan.nextLine();
			


			if (continua.equals("s")) {
				System.out.println("Quanti posti si desidera prenotare? ");
				int postiAgg = scan.nextInt();
				scan.nextLine();
				evento.prenota(postiAgg);
				System.out.println("Numero di posti prenotati: " + evento.getPostiPrenotati());
				//provvisorio
				int postiDisponibili = postiTot - evento.getPostiPrenotati();
				System.out.println("Numero di posti disponibili: " + postiDisponibili);


			} else {
				System.out.println("Operazione terminata");
			}
			
			//disd
			System.out.println("Si desidera disdire prenotazione? s/n: ");
			String cancel = scan.nextLine();

			if (cancel.equals("s")) {
				System.out.println("Quanti posti si desidera disdire? ");
				int disd = scan.nextInt();
				if (disd <= evento.getPostiPrenotati()) {
					System.out.println(evento.disdici(disd));

					System.out.println("Numero di posti prenotati: " + evento.getPostiPrenotati());
					//provvisorio
					int postiDisponibili = postiTot - evento.getPostiPrenotati();
					System.out.println("Numero di posti disponibili: " + postiDisponibili);
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
