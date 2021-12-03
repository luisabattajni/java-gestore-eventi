package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;
//import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//lato organizzativo
		
		
		System.out.println("Inserite il titolo dell'evento che desiderate organizzare: ");
		String titolo = scan.nextLine();
		//sposto un attimo sopra i posti, finché non risolvo data
		System.out.println("Inserite il numero totale dei posti: ");
		int postiTot = scan.nextInt();
		
		//LocalDate???
		
//		System.out.println("Inserite la data (dd/MM/yyyy): ");
		System.out.println("giorno: ");
		int dd = scan.nextInt();
		System.out.println("mese: ");
		int mm = scan.nextInt();
		System.out.println("anno: ");
		int yyyy = scan.nextInt();
		LocalDate data = LocalDate.of(yyyy, mm, dd);
//		System.out.println("Data: " + data);
		//debug
		
		

		//lato utente
		
		try {
		Evento evento = new Evento (titolo, data, postiTot);

		boolean vuoiPrenotare = true;
		boolean errore = false;
		
        System.out.println("Si desidera effettuare una prenotazione? s/n: ");
        String prenotaSN = scan.nextLine();

		
		if (prenotaSN.equals("s")) {
			//continua chiedendo quanti posti
			System.out.println("Prova");
		} else if (prenotaSN.equals("n")) {
			System.out.println("Operazione terminata"); //bit ominous
		} else {
          System.out.println("Prego utilizzare unicamente (s/n).");

		}
		

			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		


		
		
scan.close();
	}
	
}
