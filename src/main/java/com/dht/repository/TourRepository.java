/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Booking;
import com.dht.pojo.Tour;
import java.util.List;

/**
 *
 * @author huynh
 */
public interface TourRepository {
    List<Tour> getTour(String kw, int page);
    void addTour(Tour tour);
    Tour getTourById(Integer id);
    void editTour(Tour tour);
    void deleteTour(Tour tour);
    int countTours();
    boolean addOrUpdateTour(Tour t);
    void bookingTour (Tour tour, Booking booking);
}
