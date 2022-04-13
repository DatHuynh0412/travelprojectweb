/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Booking;
import com.dht.repository.BookRepository;
import com.dht.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */
@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookRepository bookRepository;
    
    
    @Override
    public void booking(Integer id, Booking book) {
        bookRepository.booking(id, book);
    }

    @Override
    public List<Booking> getList(String string) {
        return bookRepository.getList(string);
    }
    
}
