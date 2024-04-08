package com.example.webserviceclient.cli;


import com.example.webserviceclient.models.Agence;
import com.example.webserviceclient.models.Chambre;
import com.example.webserviceclient.models.Offre;
import com.example.webserviceclient.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Component
public class OffreRestClientCLI extends AbstractMain implements CommandLineRunner {
	/* ATTRIBUTES */
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static String URI_OFFRE;
	private static String URI_COMPARATEUR;
	private static String URI_RESERVATION;
	public  static HashMap<String, String> agences = new HashMap<String, String>();
	
	/* METHODS */
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			inputReader = new BufferedReader(
					new InputStreamReader(System.in));
			// l'utilisateur va entrer l'url
			setTestServiceUrl(inputReader);
			URI_OFFRE = SERVICE_URL + "/afficherOffres";
			URI_COMPARATEUR = SERVICE_URL +"/comparateur";
			URI_RESERVATION = SERVICE_URL + "/reservation";
			agences.put("1", "123");
			agences.put("2", "456");
			
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader, userInput, proxy);
				Thread.sleep(3000);

			} while(!userInput.equals(QUIT));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals(
				"http://localhost:8090/webservice1");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quitter.");
		builder.append("\n1. Comparateur.");
		builder.append("\n2. Afficher les offres.");
		
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader, 
			String userInput, RestTemplate proxy) {
		Map<String, String> params = new HashMap<>();
		inputProcessor = new IntegerInputProcessor(reader);
		try {
			switch(userInput) {
				case "1":
					System.out.println("Bienvenu au comparateur: ");
					System.out.print("Ville: ");
					String villeH = reader.readLine();
					System.out.print("Date Arrivee: ");
					String dateArriveeC = reader.readLine();
					System.out.printf("date de depart: ");
					String dateDeDepartC = reader.readLine();
					System.out.printf("Prix Min: ");
					String prixMinC = reader.readLine();
					System.out.printf("prixMax: ");
					String prixMaxC = reader.readLine();
					System.out.printf("Nombre d'etoile: ");
					String nbrEtoileH = reader.readLine();
					System.out.printf("nombre de perssonnes: ");
					String nombrePersonnes = reader.readLine();
					String lien1 = "?ville="+villeH +"&dateArrivee="+dateArriveeC+"&dateDeDepart="+dateDeDepartC+"&prixMin="+prixMinC+"&prixMax="+prixMaxC+"&nbrEtoile="+nbrEtoileH+"&nbrPersonnes="+nombrePersonnes;
					String uri1 = URI_COMPARATEUR + lien1;
					Offre[] comparateurOffre = proxy.getForObject(uri1, Offre[].class);
					int i = 0;
					System.out.println("Offres: ");
					System.out.println();
					for (Offre c : comparateurOffre) {
						System.out.println("ID Offre: "+(++i));
						System.out.println("ID Chambre: "+String.valueOf(c.getIdChambre()));
						System.out.println("Type chambre: "+String.valueOf(c.getTypeChambre()));
						System.out.println("Nombre de lits: "+String.valueOf(c.getNbrLit()));
						System.out.println("Prix par nuit: "+String.valueOf(c.getPrixNuit()));
						System.out.println("Image de la chambre: "+String.valueOf("http://localhost:8090/"+c.getImage()));
						System.out.println("Nom Hotel: "+String.valueOf(c.getNomHotel()));
						System.out.println("Nombre d'etoile: "+String.valueOf(c.getNbrEtoile()));
						System.out.println("L'adresse de l'hotel: "+ String.valueOf(c.getAdresseHotel()));
						System.out.println("Disponibilite: "+ String.valueOf(c.getDisponibilite()));
						System.out.println("ID agence: "+ String.valueOf(c.getIdAgence()));
						System.out.println();
					}
					System.out.println();
					break;
				
				case "2":
					// Web Service 1
					// getting infos from the user
					System.out.printf("ID agence: ");
					String idAgence = reader.readLine();
					System.out.print("Mot de passe de l'agence: ");
					String motDePasse = reader.readLine();
					if((idAgence.equals("1") && motDePasse.equals(agences.get("1")))||(idAgence.equals("2") && motDePasse.equals(agences.get("2")))) {
						System.out.println("Bienvenu: ");
						System.out.print("Ville: ");
						String ville = reader.readLine();
						System.out.print("Date Arrivee: ");
						String dateArrivee = reader.readLine();
						System.out.printf("date de depart: ");
						String dateDeDepart = reader.readLine();
						System.out.printf("Prix Min: ");
						String prixMin = reader.readLine();
						System.out.printf("prixMax: ");
						String prixMax = reader.readLine();
						System.out.printf("Nombre d'etoile: ");
						String nbrEtoile = reader.readLine();
						System.out.printf("nombre de perssonnes: ");
						String nbrPersonnes = reader.readLine();
						String lien2 = "?ville="+ville +"&dateArrivee="+dateArrivee+"&dateDeDepart="+dateDeDepart+"&prixMin="+prixMin+"&prixMax="+prixMax+"&nbrEtoile="+nbrEtoile+"&nbrPersonnes="+nbrPersonnes+"&idAgence="+idAgence;
						String uri2 = URI_OFFRE + lien2;
						Offre[] Offres = proxy.getForObject(uri2, Offre[].class);
						System.out.println("Offres: ");
						System.out.println();
						for (Offre e : Offres) {
							System.out.println("ID Offre: "+String.valueOf(e.getIdOffre()));
							System.out.println("ID Chambre: "+String.valueOf(e.getIdChambre()));
							System.out.println("Type chambre: "+String.valueOf(e.getTypeChambre()));
							System.out.println("Nombre de lits: "+String.valueOf(e.getNbrLit()));
							System.out.println("Prix par nuit: "+String.valueOf(e.getPrixNuit()));
							System.out.println("Image de la chambre: "+String.valueOf("http://localhost:8090/"+e.getImage()));
							System.out.println("Nom Hotel: "+String.valueOf(e.getNomHotel()));
							System.out.println("Nombre d'etoile: "+String.valueOf(e.getNbrEtoile()));
							System.out.println("L'adresse de l'hotel: "+ String.valueOf(e.getAdresseHotel()));
							System.out.println("Disponibilite: "+ String.valueOf(e.getDisponibilite()));
							System.out.println("ID agence: "+ String.valueOf(e.getIdAgence()));
							System.out.println();

						}
						System.out.println();
						// L'utilisation du service web 2
						System.out.println("Si vous voulez reserver une chambre tapez o sinon tapez n'import quel caractere");
						String reponse = reader.readLine();
						if(reponse.equals("o")){
							// Effectuer la reservation
							System.out.println();
							System.out.print("Entrez l'ID de l'offre que vous voulez reserver: ");
							String choixOffre = reader.readLine();
							for (Offre e : Offres) {
								String getOffre = String.valueOf(e.getIdOffre());
								if ((getOffre.equals(choixOffre)) && (e.getDisponibilite().equals("disponible"))) {
									System.out.println("Pour finaliser votre reservation on a besoin de vos informations personnelles: ");
									System.out.print("Nom: ");
									String nomClient = reader.readLine();
									System.out.print("Prenom: ");
									String prenomClient = reader.readLine();
									System.out.println("Les information du paiement: ");
									System.out.print("numero de la carte bancaire: ");
									String numCarte = reader.readLine();
									System.out.print("Date de fin de validite: ");
									String dateFinVal = reader.readLine();
									System.out.print("Code cvc: ");
									String code = reader.readLine();
									System.out.println();
									String uri3 = URI_RESERVATION;
									Chambre chambre = new Chambre();
									chambre.setId_chambre(e.getIdChambre());
									Agence agence = new Agence();
									agence.setIdAgence(Long.valueOf(idAgence));
									Reservation reservation = new Reservation(nomClient, prenomClient, numCarte, dateFinVal, Integer.parseInt(choixOffre), e.getNomHotel(), chambre, dateArrivee, dateDeDepart, agence, (e.getPrixNuit() * countDaysBetweenDates(dateArrivee, dateDeDepart)));
									Reservation returnedReservation = proxy.postForObject(uri3, reservation, Reservation.class);
									// Afficher la reservation
									System.out.println("Reservation confirmee");
									System.out.println("Les information de la reservation:");
									System.out.println("Reference de la reservation: "+ returnedReservation.getNumReservation());
									System.out.println("Nom client: "+ returnedReservation.getNomClient());
									System.out.println("Prenom client: "+ returnedReservation.getPrenomClient());
									System.out.println("ID offre: "+ returnedReservation.getIdOffre());
									System.out.println("date d'arrivee: "+ returnedReservation.getDateArrivee());
									System.out.println("date de depart: "+ returnedReservation.getDateDepart());
									System.out.println("ID chambre: "+ returnedReservation.getChambre().getId_chambre());
									System.out.println("Nom hotel: "+ returnedReservation.getNomHotel());
									System.out.println("ID agence: "+ returnedReservation.getAgence().getIdAgence());
									System.out.println("Prix Total: "+ returnedReservation.getPrixTotal());
									System.out.println();
									break;
								}else {
									System.out.println("Cette chambre est indisponible durant cette peroide");
									break;
								}
							}

						}else {
							System.out.println("Bye...");
						}

						break;

					}else {
						System.out.println("ID ou Mot de passe erronne");
						break;
					}

				case QUIT:
					System.out.println("Bye...");
					System.exit(0);
				
				default:
					System.err.println("Sorry, wrong input. Please try again.");
					return;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			System.err.println(e.getMessage());
			System.err.println("Please try again with a different ID.");
		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	// a method that calculates the number of days
	public static long countDaysBetweenDates(String date1, String date2) {
		// Parse the input strings into LocalDate objects
		LocalDate localDate1 = LocalDate.parse(date1);
		LocalDate localDate2 = LocalDate.parse(date2);

		// Calculate the difference between the dates
		long daysDifference = ChronoUnit.DAYS.between(localDate1, localDate2);

		// Return the absolute value to handle cases where date2 is before date1
		return Math.abs(daysDifference);
	}

}
