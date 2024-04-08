package com.example.webserviceclient.models;

import jakarta.persistence.OneToOne;

public class Adresse {

    // Attributes
    private long idAdresse;
    private String paysHotel;
    private String villeHotel;
    private String rueHotel;
    private String numero;
    private String lieuDit;
    private String positionGPS;

    // One-to-One relationship with Hotel
    @OneToOne(mappedBy = "adressHotel")
    private Hotel hotel;


    // Constructor
    public Adresse() {
    }

    public Adresse(long idAdresse, String paysHotel, String villeHotel, String rueHotel, String numero, String lieuDit, String positionGPS) {
        this.idAdresse = idAdresse;
        this.paysHotel = paysHotel;
        this.villeHotel = villeHotel;
        this.rueHotel = rueHotel;
        this.numero = numero;
        this.lieuDit = lieuDit;
        this.positionGPS = positionGPS;
    }

    public long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getPaysHotel() {
        return paysHotel;
    }

    public void setPaysHotel(String paysHotel) {
        this.paysHotel = paysHotel;
    }

    public String getVilleHotel() {
        return villeHotel;
    }

    public void setVilleHotel(String villeHotel) {
        this.villeHotel = villeHotel;
    }

    public String getRueHotel() {
        return rueHotel;
    }

    public void setRueHotel(String rueHotel) {
        this.rueHotel = rueHotel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLieuDit() {
        return lieuDit;
    }

    public void setLieuDit(String lieuDit) {
        this.lieuDit = lieuDit;
    }

    public String getPositionGPS() {
        return positionGPS;
    }

    public void setPositionGPS(String positionGPS) {
        this.positionGPS = positionGPS;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}

