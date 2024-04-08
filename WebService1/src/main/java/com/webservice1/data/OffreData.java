package com.webservice1.data;

import com.webservice1.models.*;
import com.webservice1.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.HashSet;

@Configuration
public class OffreData {

    private Logger logger = LoggerFactory.getLogger(OffreData.class);

    @Bean
    public CommandLineRunner initDatabase(HotelRepository hotelRepository, AdresseRepository adresseRepository, AgenceRepository agenceRepository, ChambreRepository chambreRepository, PartenariatRepositrory partenariatRepositrory, ReservationRepository reservationRepository, OffreRepository offreRepository) {
        return args ->{
            logger.info("Successfully Connected to DataBase ");
            // Creating Hotels
            Hotel hotel1 = new Hotel(1, "Brit Hotel",  new Adresse(1, "France", "Montpellier", "861 rue de la croix verte", "861", "Euromedecine", "43.64466934706808, 3.8424375029576603"), 2, new HashSet<>(), new HashSet<>());
            Hotel hotel2 = new Hotel(2, "Ibis Budget hotel",  new Adresse(2, "France", "Montpellier", "Zac Blaise Pascal, 25 Rue des Frères Lumière", "25", "Millénaire - Grammont", "43.61069871111124, 3.9058601828636244"), 2, new HashSet<>(), new HashSet<>());
            Hotel hotel3 = new Hotel(3, "Hôtel des Ambassadeurs",  new Adresse(3, "France", "Toulouse", "68 Rue de Bayard", "68", "Matabiau", "43.610940960840615, 1.4516332963581684"), 2, new HashSet<>(), new HashSet<>());
            logger.info("Preloading data with: "+ hotelRepository.save(hotel1));
            logger.info("Preloading data with: "+ hotelRepository.save(hotel2));
            logger.info("Preloading data with: "+ hotelRepository.save(hotel3));
            // Creating Rooms
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(1, "chambre Simple", 1, 20, "22872571.jpg", "d", hotel1)));
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(2, "chambre double", 2, 30, "75142578.jpg","d", hotel1)));
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(3, "chambre Simple", 1, 25, "118894710.jpg","d", hotel2)));
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(4, "chambre double", 2, 35, "253387236.jpg","d", hotel2)));
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(5, "chambre double", 2, 30, "480468189.jpg","d", hotel3)));
            logger.info("Preloading data with: "+chambreRepository.save(new Chambre(6, "chambre triple", 3, 45, "480468189.jpg","d", hotel3)));
            // Creating Agencies
            Agence agence1 = new Agence(1, "DH Travel", "123", new HashSet<>());
            Agence agence2 = new Agence(2, "Booking", "456", new HashSet<>());
            logger.info("Preloading data with: "+agenceRepository.save(agence1));
            logger.info("Preloading data with: "+agenceRepository.save(agence2));
            // Creation Partenariat
            logger.info("Prealoading data with: "+ partenariatRepositrory.save(new Partenariat(1, hotel1, agence1, 25)));
            logger.info("Prealoading data with: "+ partenariatRepositrory.save(new Partenariat(2, hotel1, agence2, 10)));
            logger.info("Preloading data with: "+ partenariatRepositrory.save(new Partenariat(3, hotel2, agence1, 15)));
            logger.info("Prealoading data with: "+ partenariatRepositrory.save(new Partenariat(4, hotel2, agence2, 30)));
            logger.info("Preloading data with: "+ partenariatRepositrory.save(new Partenariat(5, hotel3, agence1, 18)));
            logger.info("Preloading data with: "+ partenariatRepositrory.save(new Partenariat(6, hotel3, agence2, 25)));
            // creating Reservation
            //logger.info("Preloading data with reservation: "+reservationRepository.save(new Reservation("dehimat","abdou","123","08/26",1,"Brit Hotel", new Chambre(2, "chambre double", 2, 30, "75142578.jpg","disponible", hotel1),"2023-11-10","2023-11-20",agence1,100)));
            // Creation Offre
            //logger.info("Preloading data with offre: "+offreRepository.save(new Offre(1,1,"test","test", 2, "test", 2,100,1,"disponible","test.jpj")));
        };
    }

    private java.sql.Date convertStringToDate(String dateString) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = format.parse(dateString);
        return new java.sql.Date(utilDate.getTime());
    }

}
