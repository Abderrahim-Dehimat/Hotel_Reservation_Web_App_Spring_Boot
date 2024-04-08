package com.webservice1.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Partenariat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Many-to-One relationship with Hotel
    @ManyToOne
    @JoinColumn(name = "idHotel", nullable = false)
    private Hotel hotel;

    // Many-to-One relationship with Agence
    @ManyToOne
    @JoinColumn(name = "idAgence", nullable = false)
    private Agence agence;

    @Column(name = "pourcentage", nullable = false)
    private int pourcentage;

    // Constructor

    public Partenariat() {
    }

    public Partenariat(long id, Hotel hotel, Agence agence, int pourcentage) {
        this.id = id;
        this.hotel = hotel;
        this.agence = agence;
        this.pourcentage = pourcentage;
    }

    // Methods


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

}
