package com.example.javaweb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

   @GetMapping("/index")
   public String goHome() {
       return "index";
   }

    @RequestMapping("/login")
    public String login() {
       return "login";
    }

    @GetMapping("/logout")
    public String logout(){
       return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

//    } @GetMapping("/projects")
//    public String projects() {
//        return "projects";
//    }




}
