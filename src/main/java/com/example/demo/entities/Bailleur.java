package com.example.demo.entities;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="bailleur_fond")

public class Bailleur {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotNull(message = "intitule cannot be null")
    private String intitule;

    @NotNull(message = "adresse cannot be null")
    private String adresse;

    @NotNull(message = "ville cannot be null")
    private String ville;

    @NotNull(message = "telephone cannot be null")
    private String telephone;

    @NotNull(message = "fax cannot be null")
    private String fax;

    @NotNull(message = "email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "somme de participation cannot be null")
    private Float somme_participation;


    @OneToMany(mappedBy="bailleur",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Financement> financements;

    public Bailleur() {
    }


    public Bailleur(Long id, Long code, String intitule, String adresse, String ville, String telephone, String fax, String email, Float somme_participation, Set<Financement> financements) {
        this.id = id;
        this.code = code;
        this.intitule = intitule;
        this.adresse = adresse;
        this.ville = ville;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.somme_participation = somme_participation;
        this.financements = financements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSomme_participation() {
        return somme_participation;
    }

    public void setSomme_participation(Float somme_participation) {
        this.somme_participation = somme_participation;
    }


   public Set<Financement> getFinancements() {
       return financements;
   }

  public void setFinancements(Set<Financement> financements) {
   this.financements = financements;
   }

    @Override
    public String toString() {
        return "Bailleur{" +
                "id=" + id +
                ", code=" + code +
                ", intitule='" + intitule + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", somme_participation=" + somme_participation +
                '}';
    }
}