package com.webservice1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Entity
public class Agence {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
