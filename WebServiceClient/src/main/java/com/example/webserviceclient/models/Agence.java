package com.example.webserviceclient.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class Agence {

    // Attributes
    private long idAgence;

    private String nomAgence;
    private String motDePasse;

    // One-to-Many relationship with Partenariat
    @OneToMany(mappedBy = "agence")
    private Set<Partenariat> partenariats;

    // Constructor

    public Agence() {
    }

    public Agence(long idAgence, String nomAgence, String motDePasse, Set<Partenariat> partenariats) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.motDePasse = motDePasse;
        this.partenariats = partenariats;
    }


    public Long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(Long idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Set<Partenariat> getPartenariats() {
        return partenariats;
    }

    public void setPartenariats(Set<Partenariat> partenariats) {
        this.partenariats = partenariats;
    }

}

