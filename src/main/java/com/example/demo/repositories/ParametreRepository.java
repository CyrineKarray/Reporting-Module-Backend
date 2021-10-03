package com.example.demo.repositories;

import com.example.demo.entities.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {

    Optional<Parametre> findById (Long id);
}
