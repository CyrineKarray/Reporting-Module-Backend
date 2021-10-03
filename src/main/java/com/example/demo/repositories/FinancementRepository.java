package com.example.demo.repositories;

import com.example.demo.entities.Financement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinancementRepository extends JpaRepository<Financement, Long> {
    Optional<Financement> findById (Long id);
    Optional<Financement> findFinancementByCode(Long code);

    @Query("SELECT count(*) FROM Financement")
    long countFinancement();

}


