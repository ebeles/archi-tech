package com.example.javaweb.controllers;

import com.example.javaweb.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/materials")
    public String showMaterialsPage(Model model){

        model.addAttribute("materials", materialService.findAll());

        return "services";
    }

    @PostMapping("/addMaterial")
    public String saveObject(@RequestParam("name") String name,
                             @RequestParam("price") Double price){

        materialService.saveToDb(name,price);
        return"redirect:/materials";
    }




}
