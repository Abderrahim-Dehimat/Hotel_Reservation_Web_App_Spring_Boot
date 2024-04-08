package com.webservice1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ComparateurOffre {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_chambre;
    private String type_chambre;
    private int nbr_lit;
    private double prix_nuit;
    private String image_chambre;
    public String disponibilite;


    // Many-to-One relationship with Hotel
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idHotel", nullable = false)
    private Hotel hotel;

    public ComparateurOffre() {
    }

    public ComparateurOffre(long id_chambre, String type_chambre, int nbr_lit, double prix_nuit, String image_chambre, String disponibilite, Hotel hotel) {
        this.id_chambre = id_chambre;
        this.type_chambre = type_chambre;
        this.nbr_lit = nbr_lit;
        this.prix_nuit = prix_nuit;
        this.image_chambre = image_chambre;
        this.disponibilite = disponibilite;
        this.hotel = hotel;
    }

    public long getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(long id_chambre) {
        this.id_chambre = id_chambre;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public int getNbr_lit() {
        return nbr_lit;
    }

    public void setNbr_lit(int nbr_lit) {
        this.nbr_lit = nbr_lit;
    }

    public double getPrix_nuit() {
        return prix_nuit;
    }

    public void setPrix_nuit(double prix_nuit) {
        this.prix_nuit = prix_nuit;
    }

    public String getImage_chambre() {
        return image_chambre;
    }

    public void setImage_chambre(String image_chambre) {
        this.image_chambre = image_chambre;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
