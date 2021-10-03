package com.example.demo.repositories;


import com.example.demo.entities.Bailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BailleurRepository extends JpaRepository<Bailleur, Long> {

    Optional<Bailleur> findById (Long id);
    Optional<Bailleur> findBailleurByCode(Long code);
}
