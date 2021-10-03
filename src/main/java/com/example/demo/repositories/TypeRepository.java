package com.example.demo.repositories;

import com.example.demo.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findById (Long id);
    Optional<Type> findTypeByCode(Long code);
}