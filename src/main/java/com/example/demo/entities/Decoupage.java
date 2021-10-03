package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="decoupage_analytique")

//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Decoupage {
        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long id;


        @NotNull(message = "code cannot be null")
        private Long code;

        @NotBlank
        @NotNull(message = "designation cannot be null")
        @Size(min = 2, max = 20, message = "Designation between 2 and 20 characters")
        private String designation;

        @NotBlank
        @NotNull(message = "niveau cannot be null")
        private Integer niveau;

        @NotNull(message = "date_debut cannot be null")
        private LocalDate date_deb;

        @NotNull(message = "date_debut cannot be null")
        private LocalDate date_fin;

        @NotBlank
        @NotNull(message = "budget cannot be null")
        private Float budget;

        @NotBlank
        @NotNull(message = "observation cannot be null")
        @Size(min = 2, max = 20, message = "observation between 2 and 20 characters")
        private String observation;

        @NotBlank
        @NotNull(message = "localisation cannot be null")
        @Size(min = 2, max = 20, message = "localisation between 2 and 20 characters")
        private String localisation;

        @NotBlank
        @NotNull(message = "coordinateur cannot be null")
        private String coordinateur;

        @NotBlank
        @NotNull(message = "facilitation number cannot be null")
        @Size(min = 8, max = 15, message = "facilitation between 8 and 15 characters")
        private String facilitation;

        @NotBlank
        @NotNull(message = "resultat_attendu cannot be null")
        @Size(min = 2, max = 20, message = "resultat_attendu between 2 and 20 characters")
        private String resultat_attendu;

        @NotBlank
        @NotNull(message = "objectif_global_dev cannot be null")
        @Size(min = 2, max = 20, message = "objectif_global_dev between 2 and 20 characters")
        private String objectif_global_dev;

        @NotBlank
        @NotNull(message = "objectif_global_durable cannot be null")
        @Size(min = 2, max = 20, message = "objectif_global_durable between 2 and 20 characters")
        private String objectif_global_durable;

        @NotBlank
        @NotNull(message = "Contexte number cannot be null")
        @Size(min = 8, max = 15, message = "Contexte between 8 and 15 characters")
        private String contexte;

        @OneToMany(mappedBy="decoupage")
        @JsonIgnore
        private Set<Indicateur> indicateurs;

        @OneToMany(mappedBy="decoupage")
        @JsonIgnore
        private Set<Financement> financements;


        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(name="degre_id")
        Degre degre_id;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(name="secteur_id")
        Secteur secteur_id;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(name="pole_id")
        Pole pole_id;



    public Decoupage(){}

    public Decoupage(Long id, Long code, String designation, Integer niveau, LocalDate date_deb, LocalDate date_fin, Float budget, String observation, String localisation, String coordinateur, String facilitation, String resultat_attendu, String objectif_global_dev, String objectif_global_durable, String contexte, Set<Indicateur> indicateurs, Set<Financement> financements, Degre degre_id, Secteur secteur_id, Pole pole_id) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.niveau = niveau;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.budget = budget;
        this.observation = observation;
        this.localisation = localisation;
        this.coordinateur = coordinateur;
        this.facilitation = facilitation;
        this.resultat_attendu = resultat_attendu;
        this.objectif_global_dev = objectif_global_dev;
        this.objectif_global_durable = objectif_global_durable;
        this.contexte = contexte;
        this.indicateurs = indicateurs;
        this.financements = financements;
        this.degre_id = degre_id;
        this.secteur_id = secteur_id;
        this.pole_id = pole_id;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public LocalDate getdate_deb() {
        return date_deb;
    }

    public void setdate_deb(LocalDate date_deb) {
        this.date_deb = date_deb;
    }

    public LocalDate getdate_fin() {
        return date_fin;
    }

    public void setdate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getCoordinateur() {
        return coordinateur;
    }

    public void setCoordinateur(String coordinateur) {
        this.coordinateur = coordinateur;
    }

    public String getFacilitation() {
        return facilitation;
    }

    public void setFacilitation(String facilitation) {
        this.facilitation = facilitation;
    }

    public String getResultat_attendu() {
        return resultat_attendu;
    }

    public void setResultat_attendu(String resultat_attendu) {
        this.resultat_attendu = resultat_attendu;
    }

    public String getObjectif_global_dev() {
        return objectif_global_dev;
    }

    public void setObjectif_global_dev(String objectif_global_dev) {
        this.objectif_global_dev = objectif_global_dev;
    }

    public String getObjectif_global_durable() {
        return objectif_global_durable;
    }

    public void setObjectif_global_durable(String objectif_global_durable) {
        this.objectif_global_durable = objectif_global_durable;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public Set<Indicateur> getIndicateurs() {
        return indicateurs;
    }

    public void setIndicateurs(Set<Indicateur> indicateurs) {
        this.indicateurs = indicateurs;
    }

    public Set<Financement> getFinancements() {
        return financements;
    }

    public void setFinancements(Set<Financement> financements) {
        this.financements = financements;
    }


    public Degre getDegre_id() {
        return degre_id;
    }

    public void setDegre_id(Degre degre_id) {
        this.degre_id = degre_id;
    }

    public Secteur getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(Secteur secteur_id) {
        this.secteur_id = secteur_id;
    }


    public Pole getPole_id() {
        return pole_id;
    }

    public void setPole_id(Pole pole_id) {
        this.pole_id = pole_id;
    }

    @Override
    public String toString() {
        return "Decoupage{" +
                "id=" + id +
                ", code=" + code +
                ", designation='" + designation + '\'' +
                ", niveau=" + niveau +
                ", date_deb=" + date_deb +
                ", date_fin=" + date_fin +
                ", budget=" + budget +
                ", observation='" + observation + '\'' +
                ", localisation='" + localisation + '\'' +
                ", coordinateur='" + coordinateur + '\'' +
                ", facilitation='" + facilitation + '\'' +
                ", resultat_attendu='" + resultat_attendu + '\'' +
                ", objectif_global_dev='" + objectif_global_dev + '\'' +
                ", objectif_global_durable='" + objectif_global_durable + '\'' +
                ", contexte='" + contexte + '\'' +
                ", indicateurs=" + indicateurs +
                ", financements=" + financements +
                ", degre_id=" + degre_id +
                ", secteur_id=" + secteur_id +
                ", pole_id=" + pole_id +
                '}';
    }
}
