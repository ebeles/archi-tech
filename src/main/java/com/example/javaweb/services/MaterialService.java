package com.example.javaweb.services;


import com.example.javaweb.models.Material;
import com.example.javaweb.repositories.MaterialRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;


    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    public void saveToDb(String name, Double price) {
        Material material = new Material();
        material.setName(name);
        material.setPrice(price);

        materialRepository.save(material);
    }

    public Material findById(Integer id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Material not found"));
    }


}
