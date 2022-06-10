package com.example.javaweb.repositories;

import com.example.javaweb.models.SummaryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryItemRepository extends JpaRepository<SummaryItem, Integer> {
}
