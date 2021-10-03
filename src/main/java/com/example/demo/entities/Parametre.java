package com.example.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="parametre")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Parametre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotNull(message = "valeur cannot be null")
    private Integer valeur;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="indicateur_id")
    Indicateur indicateur;


    public Parametre(){
    }


    public Parametre(long id, Integer valeur, Indicateur indicateur) {
        this.id = id;
        this.valeur = valeur;
        this.indicateur = indicateur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Indicateur getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(Indicateur indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public String toString() {
        return "Parametre{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", indicateur=" + indicateur +
                '}';
    }
}
