package com.example.webserviceclient.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Offre {

    private long id_offre;
    private int idChambre;
    private String typeChambre;
    private String nomHotel;
    private Integer nbrEtoile;
    private String adresseHotel;
    private Integer nbrLit;
    @Column(name = "PRIX_NUIT", nullable = false)
    private Double prixNuit;
    private Long idAgence;
    private String disponibilite;
    private String image;

    // Empty Constructor
    public Offre() {
    }

    // Constructor
    public Offre(long idOffre, int idChambre, String typeChambre, String nomHotel, int nbrEtoile, String adresseHotel, int nbrLit, double prixNuit, Long idAgence, String disponibilite, String image) {
        this.id_offre = idOffre;
        this.idChambre = idChambre;
        this.typeChambre = typeChambre;
        this.nomHotel = nomHotel;
        this.nbrEtoile = nbrEtoile;
        this.adresseHotel = adresseHotel;
        this.nbrLit = nbrLit;
        this.prixNuit = prixNuit;
        this.idAgence = idAgence;
        this.disponibilite = disponibilite;
        this.image = image;
    }

    // Getters and Setters (omitted for brevity)


    public long getIdOffre() {
        return id_offre;
    }

    public void setIdOffre(long idOffre) {
        this.id_offre = idOffre;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public Integer getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(Integer nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public String getAdresseHotel() {
        return adresseHotel;
    }

    public void setAdresseHotel(String adresseHotel) {
        this.adresseHotel = adresseHotel;
    }

    public Integer getNbrLit() {
        return nbrLit;
    }

    public void setNbrLit(Integer nbrLit) {
        this.nbrLit = nbrLit;
    }

    public Double getPrixNuit() {
        return prixNuit;
    }

    public void setPrixNuit(Double prixNuit) {
        this.prixNuit = prixNuit;
    }

    public Long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Long nomAgence) {
        this.idAgence = nomAgence;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

