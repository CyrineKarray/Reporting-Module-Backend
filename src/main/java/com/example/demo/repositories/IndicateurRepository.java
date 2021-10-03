package com.example.demo.repositories;

import com.example.demo.entities.Indicateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IndicateurRepository extends JpaRepository<Indicateur, Long> {

    Optional<Indicateur> findById (Long id);
    Optional<Indicateur> findIndicateurByCode(Long id);
}


