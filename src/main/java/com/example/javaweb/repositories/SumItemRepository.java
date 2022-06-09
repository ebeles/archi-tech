package com.example.javaweb.repositories;

import com.example.javaweb.models.SumItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SumItemRepository extends JpaRepository<SumItem, Integer> {
}
