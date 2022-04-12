/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Tour;
import com.dht.pojo.User;
import com.dht.service.StatsService;
import com.dht.service.TourService;
//import com.dht.pojo.User;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author huynh
 */
@Controller
public class HomeController {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TourService tourService;
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "search", required = false) String kw,
                                     @RequestParam(name = "page", defaultValue = "1") Integer page){
        model.addAttribute("Tour",tourService.getTour(kw, page));
        model.addAttribute("tourCounter", this.tourService.countTours());
        return "index";
    }
    
    @GetMapping("/login")
    public String loginView(Model model){
        model.addAttribute("User", new User());
        return "login";
    }
    
    @GetMapping("/stats")
    public String stats(Model model){
        model.addAttribute("Stats", statsService.StatList());
        
        return "stats";
    }
}
