package com.example.javaweb.repositories;

import com.example.javaweb.models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    Summary findBySessionToken(String sessionToken);
}
