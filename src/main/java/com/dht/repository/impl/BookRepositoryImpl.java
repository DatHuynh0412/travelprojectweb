/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Booking;
import com.dht.pojo.Tour;
import com.dht.pojo.User;
import com.dht.repository.BookRepository;
import com.dht.service.TourService;
import com.dht.service.UserService;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynh
 */
@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Autowired
    private TourService tourService; 
    @Autowired
    private UserService userService;
    
    @Override   
    public void booking(Integer id, Booking book) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        Tour tour = tourService.getTourById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        User user = userService.getUserByUsername(authentication.getName());
        book.setUserId(user);       
        book.setTourId(tour);
        session.save(book);
    }

    @Override
    public List<Booking> getList(String username) {
        User user = userService.getUserByUsername(username);
        List<Booking> list = user.getBookingList();
        Hibernate.initialize(list);
        return list;
    }
    
}
