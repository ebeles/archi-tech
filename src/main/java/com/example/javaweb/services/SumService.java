package com.example.javaweb.services;

import com.example.javaweb.models.Material;
import com.example.javaweb.models.Sum;
import com.example.javaweb.models.SumItem;
import com.example.javaweb.repositories.MaterialRepository;
import com.example.javaweb.repositories.SumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumService {

    @Autowired
    private SumRepository sumRepository;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MaterialRepository materialRepository;


    public Sum addToSummary(Integer id, Integer quantity){

        Material material = materialRepository.findById(id).orElse(null);

        Sum sum = new Sum();

        for(SumItem item : sum.getItems()) {
            if(material.getId().equals(item.getMaterial().getId())){
                item.setQuantity(item.getQuantity()+quantity);
                return sumRepository.save(sum);
            }
        }
        SumItem sumItem = new SumItem();
        sumItem.setQuantity(quantity);
        sumItem.setMaterial(material);
        sum.getItems().add(sumItem);
        return sumRepository.save(sum);
    }
}
