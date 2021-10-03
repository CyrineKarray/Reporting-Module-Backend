package com.example.demo.repositories;

import com.example.demo.entities.Unite;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UniteRepository extends JpaRepository<Unite, Long> {
    Optional<Unite> findById (Long id);
    Optional<Unite> findUniteByCode(Long code);
}
