package com.example.javaweb.repositories;

import com.example.javaweb.models.Sum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SumRepository extends JpaRepository<Sum, Integer> {
}
