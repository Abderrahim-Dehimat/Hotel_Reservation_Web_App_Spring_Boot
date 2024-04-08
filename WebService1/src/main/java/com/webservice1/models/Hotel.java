package com.webservice1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Entity
public class Hotel {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHotel;
    private String nom;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdresse", referencedColumnName = "idAdresse")
    private Adresse adressHotel;
    private int nbrEtoile;
    // One-to-Many relationship with Chambre

    @OneToMany(mappedBy = "hotel")
    private Set<Chambre> chambres;

    @OneToMany(mappedBy = "hotel")
    private Set<Partenariat> partenariats;

    // Constructor

    public Hotel() {
    }

    public Hotel(long idHotel, String nom, Adresse adressHotel, int nbrEtoile, Set<Chambre> chambres, Set<Partenariat> partenariats) {
        this.idHotel = idHotel;
        this.nom = nom;
        this.adressHotel = adressHotel;
        this.nbrEtoile = nbrEtoile;
        this.chambres = chambres;
        this.partenariats = partenariats;
    }

    // Methods
    public long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdressHotel() {
        return adressHotel;
    }

    public void setAdressHotel(Adresse adressHotel) {
        this.adressHotel = adressHotel;
    }

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(int nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public Set<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(Set<Chambre> chambres) {
        this.chambres = chambres;
    }

    public Set<Partenariat> getPartenariats() {
        return partenariats;
    }

    public void setPartenariats(Set<Partenariat> partenariats) {
        this.partenariats = partenariats;
    }

}
