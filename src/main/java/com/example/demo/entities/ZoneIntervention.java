package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="decoupage_analytique")
public class ZoneIntervention {
    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotBlank
    @NotNull(message = "description cannot be null")
    @Size(min = 2, max = 20, message = "description between 2 and 20 characters")
    private String description;

    @NotNull(message = "must be higher than 4 ")
    private Integer surface;

    public ZoneIntervention(){}


    public ZoneIntervention(Long id, Long code, String description, Integer surface) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.surface = surface;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "ZoneIntervention{" +
                "id=" + id +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", surface=" + surface +
                '}';
    }
}
