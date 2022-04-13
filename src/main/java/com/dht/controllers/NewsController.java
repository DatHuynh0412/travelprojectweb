/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Comment;
import com.dht.pojo.Newscomment;
import com.dht.service.CommentService;
import com.dht.service.NewsService;
import com.dht.service.NewscommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewscommentService newscommentService;
    
    
    @GetMapping("/news")
    public String newView(Model model){
        model.addAttribute("News", newsService.getNews());
        
        return "news";
    }
    
    @GetMapping("/news/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        model.addAttribute("news", newsService.getNewsByid(id));
        model.addAttribute("comment", new Newscomment());     
        model.addAttribute("commentlist", newscommentService.getComment(id));
        return "details";
    }
    
    @PostMapping("/news/{id}/comment")
    public String comment(@PathVariable("id") Integer id,
            @ModelAttribute(value = "comment") Newscomment comment){
        comment.setNewsId(newsService.getNewsByid(id));
        newscommentService.addComment(comment);
        return "redirect:/news/{id}";
    }
}
