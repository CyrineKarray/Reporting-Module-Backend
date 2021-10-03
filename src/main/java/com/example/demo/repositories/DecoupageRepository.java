package com.example.demo.repositories;


import com.example.demo.entities.Decoupage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DecoupageRepository extends JpaRepository<Decoupage, Long> {

    Optional<Decoupage> findById (Long id);
    Optional<Decoupage> findDecoupageByCode(Long id);
}
