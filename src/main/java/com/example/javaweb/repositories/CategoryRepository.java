package com.example.javaweb.repositories;

import com.example.javaweb.models.Category;
import com.example.javaweb.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
