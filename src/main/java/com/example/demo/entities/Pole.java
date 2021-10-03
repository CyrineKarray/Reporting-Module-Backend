package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name="pole_developement")
public class Pole {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "code cannot be null")
    private Long code;

    @NotBlank
    @NotNull(message = "designation cannot be null")
    @Size(min = 2, max = 20, message = "Designation between 2 and 20 characters")
    private String designation;

    @OneToMany(mappedBy="pole_id")
    @JsonIgnore
    private Set<Decoupage> decoupages;
}
