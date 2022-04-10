/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Booking;
import com.dht.pojo.Tour;
import com.dht.repository.TourRepository;
import com.dht.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */

@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Tour> getTour(String kw, int page) {
        return this.tourRepository.getTour(kw, page);
    }

    @Override
    public Tour getTourById(Integer id) {
        return this.tourRepository.getTourById(id);
    }

    @Override
    public void editTour(Tour tour) {
        this.tourRepository.editTour(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        this.tourRepository.deleteTour(tour);
    }

    @Override
    public void addTour(Tour tour) {
        this.tourRepository.addTour(tour);
    }
    
    @Override
    public int countTours() {
        return this.tourRepository.countTours();
    }

    @Override
    public boolean addOrUpdateTour(Tour tour) {
        if(tour.getMultipartFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(tour.getMultipartFile().getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                tour.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(TourServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.tourRepository.addOrUpdateTour(tour);
    }

    @Override
    public void bookingTour(Tour tour, Booking bkng) {
       
    }
}