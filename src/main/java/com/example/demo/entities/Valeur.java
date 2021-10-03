package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="valeur")
public class Valeur {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotBlank
    @NotNull(message = "designation cannot be null")
    private String designation;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="indicateur_id")
    Indicateur indicateur;


    public Valeur(){
    }

    public Valeur(long id, Long code, String designation, Indicateur indicateur) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.indicateur = indicateur;
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

    public Indicateur getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(Indicateur indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public String toString() {
        return "Valeur{" +
                "id=" + id +
                ", code=" + code +
                ", designation='" + designation + '\'' +
                ", indicateur=" + indicateur +
                '}';
    }
}
