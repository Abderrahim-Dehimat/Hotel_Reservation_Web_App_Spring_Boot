package com.example.webserviceclient.models;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    // Attributes
    private long numReservation;
    private String nomClient;
    private String prenomClient;
    private String numCarteBancaire;
    private String dateFinValidite;
    private int idOffre;
    private String nomHotel;
    @ManyToOne
    @JoinColumn(name = "ID_CHAMBRE", nullable = false)
    private Chambre chambre;
    @Column(name = "dateArrivee", nullable = false)
    private Date dateArrivee;
    @Column(name = "dateDeDepart", nullable = false)
    private Date dateDepart;

    @ManyToOne
    @JoinColumn(name = "ID_AGENCE")
    private Agence agence;
    @Column(name = "prixTotal", nullable = false)
    private double prixTotal;

    // Constructors

    public Reservation() {
    }

    public Reservation(String nomClient, String prenomClient, String numCarteBancaire, String dateFinValidite, int idOffre, String nomHotel, Chambre chambre, String dateArrivee, String dateDepart, Agence agence, double prixTotal) throws Exception {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numCarteBancaire = numCarteBancaire;
        this.dateFinValidite = dateFinValidite;
        this.idOffre = idOffre;
        this.nomHotel = nomHotel;
        this.chambre = chambre;
        this.dateArrivee = convertStringToDate(dateArrivee);
        this.dateDepart = convertStringToDate(dateDepart);
        this.agence = agence;
        this.prixTotal = prixTotal;
    }

    public long getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(long numReservation) {
        this.numReservation = numReservation;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getNumCarteBancaire() {
        return numCarteBancaire;
    }

    public void setNumCarteBancaire(String numCarteBancaire) {
        this.numCarteBancaire = numCarteBancaire;
    }

    public String getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(String dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    private java.sql.Date convertStringToDate(String dateString) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = format.parse(dateString);
        return new java.sql.Date(utilDate.getTime());
    }


}


