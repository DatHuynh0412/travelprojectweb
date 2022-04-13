/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Booking;
import com.dht.pojo.Comment;
import com.dht.pojo.Tour;
import com.dht.service.BookService;
import com.dht.service.CommentService;
import com.dht.service.TourService;
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
 * @author Admin
 */
@Controller

public class TourController {

    @Autowired
    private TourService tourService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BookService bookService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/admin/add-tour")
    public String addView(Model model) {
        model.addAttribute("Tour", new Tour());
        return "tours";
    }

    @PostMapping("/admin/add-tour")
    public String addHandler(Model model, @ModelAttribute(value = "Tour") Tour tour) {
        if (this.tourService.addOrUpdateTour(tour) == true) {
            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Something wrong!!! Please try it again later!");
        }
        return "tours";
    }

    @GetMapping("/admin/{id}/edit")
    public String editView(@PathVariable("id") Integer id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("Tour", tour);
        return "edit";
    }

    @PostMapping("/admin/{id}/edit")
    public String editHandler(Model model, @ModelAttribute("Tour") Tour tour) {
        if (!tour.getMultipartFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(tour.getMultipartFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto"
                        ));
                tour.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        tourService.editTour(tour);
        return "redirect:/";
    }

    @RequestMapping("/admin/{id}/delete")
    public String deleteTour(@PathVariable("id") Integer id) {
        Tour tour = tourService.getTourById(id);
        tourService.deleteTour(tour);
        return "redirect:/";
    }

    @GetMapping("/tours/{id}/booking")
    public String bookingView(@PathVariable("id") Integer id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("booking", new Booking());
        model.addAttribute("tour", tour);
        return "bookingtour";
    }

    @PostMapping("/tours/{id}/booking")
    public String bookingHandler(@PathVariable("id") Integer id, Model model,
            @ModelAttribute(value = "booking") Booking book
    ) {

        bookService.booking(id, book);

        return "redirect:/";
    }

    @RequestMapping("/tours/{id}")
    public String tourDetail(Model model,
            @PathVariable(name = "id") Integer id) {
        model.addAttribute("tour", this.tourService.getTourById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentlist", commentService.getComment(id));
        return "tour-detail";
    }
    
    @PostMapping("/tours/{id}/comment")
    public String comment(@PathVariable("id") Integer id,
            @RequestParam(name = "rate") String Rate,
            @ModelAttribute(value = "comment") Comment comment){
        Tour tour = tourService.getTourById(id);
        comment.setTourId(tour);
        comment.setRate(Integer.parseInt(Rate));
        commentService.addComment(comment);
        return "redirect:/tours/{id}";
    }
}
