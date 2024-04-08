package com.webservice1.controllers;

import com.webservice1.models.*;
import com.webservice1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class OffreController {

    // Attributes
    @Autowired
    private ChambreRepository repository2;
    @Autowired
    private OffreRepository repository3;
    @Autowired
    private ReservationRepository repository4;
    @Autowired
    private ComparateurOffreRepository repository5;
    private static final String uri = "webservice1";



    // The methods of web Service 1
    @GetMapping(uri+"/afficherOffres")
    public List<Offre> afficherOff(
            @RequestParam("ville") String ville,
            @RequestParam("dateArrivee") String dateArrivee,
            @RequestParam("dateDeDepart") String dateDeDepart,
            @RequestParam("prixMin") double prixMin,
            @RequestParam("prixMax") double prixMax,
            @RequestParam("nbrEtoile") int nbrEtoile,
            @RequestParam("nbrPersonnes") int nbrPersonnes,
            @RequestParam("idAgence") Long idAgence
    ) {
        // Call the service method to get the list of offres
        List<Offre> offres = new ArrayList<>();
        Random random = new Random();
        for (Chambre c : repository2.afficherOffre(ville, dateArrivee, dateDeDepart, prixMin, prixMax, nbrEtoile, nbrPersonnes, idAgence) ) {
            offres.add(new Offre(random.nextLong(1000),  (int) c.getId_chambre(), c.getType_chambre(), c.getHotel().getNom(), c.getHotel().getNbrEtoile(), c.getHotel().getAdressHotel().getVilleHotel(), c.getNbr_lit(), c.getPrix_nuit(), idAgence , c.getDisponibilite(), c.getImage_chambre()));
        }
        return offres;
    }

    // The methode of web service 2
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(uri +"/reservation")
    public Reservation effectuerReservation(@RequestBody Reservation reservation) {
        return repository4.save(reservation);
    }

    // the method of Coparateur
    @GetMapping(uri+"/comparateur")
    public List<Offre> comparerOffre(
            @RequestParam("ville") String ville,
            @RequestParam("dateArrivee") String dateArrivee,
            @RequestParam("dateDeDepart") String dateDeDepart,
            @RequestParam("prixMin") double prixMin,
            @RequestParam("prixMax") double prixMax,
            @RequestParam("nbrEtoile") int nbrEtoile,
            @RequestParam("nbrPersonnes") int nbrPersonnes
    ) {
        // Call the service method to get the list of offres
        List<Offre> offres = new ArrayList<>();
        Random random = new Random();
        for (Chambre c : repository2.afficherOffre(ville, dateArrivee, dateDeDepart, prixMin, prixMax, nbrEtoile, nbrPersonnes, (long) 2) ) {
            offres.add(new Offre(random.nextLong(1000),  (int) c.getId_chambre(), c.getType_chambre(), c.getHotel().getNom(), c.getHotel().getNbrEtoile(), c.getHotel().getAdressHotel().getVilleHotel(), c.getNbr_lit(), c.getPrix_nuit(), (long) 2 , c.getDisponibilite(), c.getImage_chambre()));
        }
        for (ComparateurOffre d : repository5.afficherOffre(ville, dateArrivee, dateDeDepart, prixMin, prixMax, nbrEtoile, nbrPersonnes, (long) 1) ) {
            offres.add(new Offre(random.nextLong(1000),  (int) d.getId_chambre(), d.getType_chambre(), d.getHotel().getNom(), d.getHotel().getNbrEtoile(), d.getHotel().getAdressHotel().getVilleHotel(), d.getNbr_lit(), d.getPrix_nuit(), (long) 1 , d.getDisponibilite(), d.getImage_chambre()));
        }
        return offres;
    }

}

