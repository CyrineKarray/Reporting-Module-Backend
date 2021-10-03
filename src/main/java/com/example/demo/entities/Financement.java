package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="financement")

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Financement {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotNull(message = "date cannot be null")
    private Date date;

    @NotNull(message = "montant device cannot be null")
    private Float montant_device;

    @NotNull(message = "montant cannot be null")
    private Float montant_monnaie_local;

    @NotNull(message = "taux de change cannot be null")
    private Float taux_change;

    @NotNull(message = "date de signature cannot be null")
    private Date date_signature;

    @NotNull(message = "date de premier paiement cannot be null")
    private Date date_premier_paiement;

    @NotNull(message = "date dernier paiement cannot be null")
    private Date date_dernier_paiement;

    @NotNull(message = "numero loi de finance cannot be null")
    private Integer numero_loi_finance;

    @NotNull(message = "budget cannot be null")
    private Date date_loi_finance;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="bailleur_id")
    Bailleur bailleur;



    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    @JoinColumn(name="decoupage_id")
    Decoupage decoupage;


    public Financement(){
    }

    public Financement(Long id, Long code, Date date, Float montant_device, Float montant_monnaie_local, Float taux_change, Date date_signature, Date date_premier_paiement, Date date_dernier_paiement, Integer numero_loi_finance, Date date_loi_finance, Bailleur bailleur, Decoupage decoupage) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.montant_device = montant_device;
        this.montant_monnaie_local = montant_monnaie_local;
        this.taux_change = taux_change;
        this.date_signature = date_signature;
        this.date_premier_paiement = date_premier_paiement;
        this.date_dernier_paiement = date_dernier_paiement;
        this.numero_loi_finance = numero_loi_finance;
        this.date_loi_finance = date_loi_finance;
        this.bailleur = bailleur;
        this.decoupage = decoupage;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getMontant_device() {
        return montant_device;
    }

    public void setMontant_device(Float montant_device) {
        this.montant_device = montant_device;
    }

    public Float getMontant_monnaie_local() {
        return montant_monnaie_local;
    }

    public void setMontant_monnaie_local(Float montant_monnaie_local) {
        this.montant_monnaie_local = montant_monnaie_local;
    }

    public Float getTaux_change() {
        return taux_change;
    }

    public void setTaux_change(Float taux_change) {
        this.taux_change = taux_change;
    }

    public Date getDate_signature() {
        return date_signature;
    }

    public void setDate_signature(Date date_signature) {
        this.date_signature = date_signature;
    }

    public Date getDate_premier_paiement() {
        return date_premier_paiement;
    }

    public void setDate_premier_paiement(Date date_premier_paiement) {
        this.date_premier_paiement = date_premier_paiement;
    }

    public Date getDate_dernier_paiement() {
        return date_dernier_paiement;
    }

    public void setDate_dernier_paiement(Date date_dernier_paiement) {
        this.date_dernier_paiement = date_dernier_paiement;
    }

    public Integer getNumero_loi_finance() {
        return numero_loi_finance;
    }

    public void setNumero_loi_finance(Integer numero_loi_finance) {
        this.numero_loi_finance = numero_loi_finance;
    }

    public Date getDate_loi_finance() {
        return date_loi_finance;
    }

    public void setDate_loi_finance(Date date_loi_finance) {
        this.date_loi_finance = date_loi_finance;
    }


    public Decoupage getDecoupage() {
        return decoupage;
    }

    public void setDecoupage(Decoupage decoupage) {
        this.decoupage = decoupage;
    }


    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    @Override
    public String toString() {
        return "Financement{" +
                "id=" + id +
                ", code=" + code +
                ", date=" + date +
                ", montant_device=" + montant_device +
                ", montant_monnaie_local=" + montant_monnaie_local +
                ", taux_change=" + taux_change +
                ", date_signature=" + date_signature +
                ", date_premier_paiement=" + date_premier_paiement +
                ", date_dernier_paiement=" + date_dernier_paiement +
                ", numero_loi_finance=" + numero_loi_finance +
                ", date_loi_finance=" + date_loi_finance +
                ", decoupage=" + decoupage +
                '}';
    }
}
