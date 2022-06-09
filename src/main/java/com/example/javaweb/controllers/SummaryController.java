package com.example.javaweb.controllers;

import com.example.javaweb.exceptions.MaterialDoesNotExistsException;
import com.example.javaweb.models.Material;
import com.example.javaweb.models.Sum;
import com.example.javaweb.models.SumItem;
import com.example.javaweb.repositories.MaterialRepository;
import com.example.javaweb.services.MaterialService;
import com.example.javaweb.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SummaryController {

    @Autowired
    private MaterialService materialService;
    @Autowired
    private SumService sumService;
    @Autowired
    private MaterialRepository materialRepository;

    @PostMapping("/addSummary/{id}")
    public String addToSummary(@PathVariable Integer id, @RequestParam("quantity") Integer quantity){
        Material material = materialRepository.findById(id).orElse(null);
        Sum sum = new Sum();
        SumItem sumItem = new SumItem();
        sumItem.setQuantity(quantity);
        sumItem.setMaterial(material);
        sum.getItems().add(sumItem);
        sumService.addToSummary(id, quantity);
        return"redirect:/materials";
    }
}
