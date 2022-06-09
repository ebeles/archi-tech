package com.example.javaweb.services;

import com.example.javaweb.models.Category;
import com.example.javaweb.models.Client;
import com.example.javaweb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();

    }

    public Optional<Category> findById(Integer id){
        return categoryRepository.findById(id);
    }
}