package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="indicateur")
public class Indicateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotBlank
    @NotNull(message = "designation cannot be null")
    @Size(min = 2, max = 20, message = "designation between 2 and 20 characters")
    private String designation;

    @NotBlank
    @NotNull(message = "frequence cannot be null")
    @Size(min = 2, max = 20, message = "frequence between 2 and 20 characters")
    private String frequence;

    @NotBlank
    @NotNull(message = "methodologie cannot be null")
    @Size(min = 2, max = 20, message = "methodologie between 2 and 20 characters")
    private String methodologie;

    @NotBlank
    @NotNull(message = "hypothese cannot be null")
    @Size(min = 2, max = 20, message = "hypothese between 2 and 20 characters")
    private String hypothese;

    @NotBlank
    @NotNull(message = "formule cannot be null")
    @Size(min = 2, max = 20, message = "formule between 2 and 20 characters")
    private String formule;

    @NotBlank
    @NotNull(message = "resp_collecte cannot be null")
    @Size(min = 2, max = 20, message = "resp_collecte between 2 and 20 characters")
    private String resp_collecte;

    @NotBlank
    @NotNull(message = "resp_synthese cannot be null")
    @Size(min = 2, max = 20, message = "resp_synthese between 2 and 20 characters")
    private String resp_synthese;

    @NotBlank
    @NotNull(message = "source_donnees cannot be null")
    @Size(min = 2, max = 20, message = "source_donnees between 2 and 20 characters")
    private String source_donnees;

    @NotBlank
    @NotNull(message = "nature cannot be null")
    @Size(min = 2, max = 20, message = "nature between 2 and 20 characters")
    private String nature;

    @NotBlank
    @NotNull(message = "definition cannot be null")
    @Size(min = 2, max = 20, message = "definition between 2 and 20 characters")
    private String definition;

    @NotBlank
    @NotNull(message = "origine cannot be null")
    @Size(min = 2, max = 20, message = "origine between 2 and 20 characters")
    private String origine;

    @NotBlank
    @NotNull(message = "risque cannot be null")
    @Size(min = 2, max = 20, message = "risque between 2 and 20 characters")
    private String risque;


    @OneToMany(mappedBy="indicateur")
    @JsonIgnore
    private Set<Parametre> parametres;



    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="decoupage_id")
    Decoupage decoupage;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="type_id")
    Type type;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="unite_id")
    Unite unite;

   // @ManyToOne
   // @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
   // @JoinColumn(name="type_id")
    //Type type;



    public Indicateur(){
    }

    public Indicateur(long id, Long code, String designation, String frequence, String methodologie, String hypothese, String formule, String resp_collecte, String resp_synthese, String source_donnees, String nature, String definition, String origine, String risque, Set<Parametre> parametres, Decoupage decoupage, Type type, Unite unite) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.frequence = frequence;
        this.methodologie = methodologie;
        this.hypothese = hypothese;
        this.formule = formule;
        this.resp_collecte = resp_collecte;
        this.resp_synthese = resp_synthese;
        this.source_donnees = source_donnees;
        this.nature = nature;
        this.definition = definition;
        this.origine = origine;
        this.risque = risque;
        this.parametres = parametres;
        this.decoupage = decoupage;
        this.type = type;
        this.unite = unite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getMethodologie() {
        return methodologie;
    }

    public void setMethodologie(String methodologie) {
        this.methodologie = methodologie;
    }

    public String getHypothese() {
        return hypothese;
    }

    public void setHypothese(String hypothese) {
        this.hypothese = hypothese;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public String getResp_collecte() {
        return resp_collecte;
    }

    public void setResp_collecte(String resp_collecte) {
        this.resp_collecte = resp_collecte;
    }

    public String getResp_synthese() {
        return resp_synthese;
    }

    public void setResp_synthese(String resp_synthese) {
        this.resp_synthese = resp_synthese;
    }

    public String getSource_donnees() {
        return source_donnees;
    }

    public void setSource_donnees(String source_donnees) {
        this.source_donnees = source_donnees;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public Set<Parametre> getParametres() {
        return parametres;
    }

    public void setParametres(Set<Parametre> parametres) {
        this.parametres = parametres;
    }

    public Decoupage getDecoupage() {
        return decoupage;
    }

    public void setDecoupage(Decoupage decoupage) {
        this.decoupage = decoupage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "Indicateur{" +
                "id=" + id +
                ", code=" + code +
                ", designation='" + designation + '\'' +
                ", frequence='" + frequence + '\'' +
                ", methodologie='" + methodologie + '\'' +
                ", hypothese='" + hypothese + '\'' +
                ", formule='" + formule + '\'' +
                ", resp_collecte='" + resp_collecte + '\'' +
                ", resp_synthese='" + resp_synthese + '\'' +
                ", source_donnees='" + source_donnees + '\'' +
                ", nature='" + nature + '\'' +
                ", definition='" + definition + '\'' +
                ", origine='" + origine + '\'' +
                ", risque='" + risque + '\'' +
                ", parametres=" + parametres +
                ", decoupage=" + decoupage +
                ", type=" + type +
                ", unite=" + unite +
                '}';
    }
}
