/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.User;
import com.dht.service.BookService;
import com.dht.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author huynh
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerHandler(Model model, 
            @ModelAttribute(value = "user") @Valid User user, 
            BindingResult result) {
        if(result.hasErrors() == true)
            return "register";

        String errMsg;
        if(user.getPassword().equals(user.getConfirmPassword())) {
            if(this.userService.addUser(user) == true)
                return "redirect:/login";
            else
                errMsg = "Something wrong! Please come back later!";
        } else {
            errMsg = "Password does'n match!";
        }

        model.addAttribute("errMsg", errMsg);

        return "register";
    }
    @GetMapping("/user/{username}")
    public String userView(@PathVariable("username") String username, Model model){
        model.addAttribute("user",userService.getUserByUsername(username));
        model.addAttribute("booklist", bookService.getList(username));
        return "userprofile";
    } 
}
