package com.example.javaweb.controllers;

import com.example.javaweb.services.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @PostMapping("/addToSummary")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Integer id,
                            @RequestParam("quantity") int quantity) {

        // sessiontToken
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if (sessionToken == null) {

            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessiontToken", sessionToken);
            summaryService.addToSummaryFirstTime(id, sessionToken, quantity);
        } else {
            summaryService.addToExcistingSummary(id, sessionToken, quantity);
        }
        return "redirect:/";
    }



}
