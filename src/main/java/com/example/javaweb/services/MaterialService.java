package com.example.javaweb.services;


import com.example.javaweb.models.Material;
import com.example.javaweb.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    public void saveToDb(String name, Double price) {
        Material material = new Material();
        material.setName(name);
        material.setPrice(price);

        materialRepository.save(material);
    }

    public Material getMaterialById(Integer id) {
        return materialRepository.findById(id).get();

    }


}
