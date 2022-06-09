package com.example.javaweb.controllers;

import com.example.javaweb.models.Category;
import com.example.javaweb.models.Client;
import com.example.javaweb.models.Object;
import com.example.javaweb.models.Status;
import com.example.javaweb.services.CategoryService;
import com.example.javaweb.services.ClientService;
import com.example.javaweb.services.ObjectService;
import com.example.javaweb.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
public class ObjectController {

    @Autowired
    private ObjectService objectService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private StatusService statusService;


    @GetMapping("/projects")
    public String getProjects(Model model) {

        model.addAttribute("projects", objectService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("statuses", statusService.findAll());


        return "portfolio";
    }

    @PostMapping("/addObject")
    public String saveObject(@RequestParam("file") MultipartFile file,
                             @RequestParam("name") String name,
                             @RequestParam("location") String location,
                             @RequestParam("description") String description,
                             @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                             @RequestParam("categoryid") Integer categoryid,
                             @RequestParam("clientid") Integer clientid,
                             @RequestParam("statusid") Integer statusid) {

        objectService.saveObjectToDB(file, name, location, description, date, categoryid, clientid, statusid);
        return "redirect:/projects";
    }

    @GetMapping("/portfolio-details")
    public String showDetails(Model model) {
        model.addAttribute("projects", objectService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("statuses", statusService.findAll());
        return "portfolio-details";
    }

    @GetMapping("/projects/{id}")
    public String viewByStatusId(Model model, @PathVariable Integer id){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("statuses", statusService.findAll());
        model.addAttribute("projects", objectService.getObjectsByStatusId(id));
        return "portfolio";
    }


}
