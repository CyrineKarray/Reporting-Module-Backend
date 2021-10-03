package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="type_indicateur")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Type {
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


    @OneToMany(mappedBy="type")
    @JsonIgnore
    private Set<Indicateur> indicateurs;


    public Type(){
    }


    public Type(long id, Long code, String designation, Set<Indicateur> indicateurs) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.indicateurs = indicateurs;
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

    public Set<Indicateur> getIndicateurs() {
        return indicateurs;
    }

    public void setIndicateurs(Set<Indicateur> indicateurs) {
        this.indicateurs = indicateurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", code=" + code +
                ", designation='" + designation + '\'' +
                ", indicateurs=" + indicateurs +
                '}';
    }
}
