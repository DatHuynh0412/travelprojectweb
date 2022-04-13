/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Booking;
import java.util.List;

/**
 *
 * @author huynh
 */
public interface BookRepository {
    void booking(Integer id,Booking book);
    List<Booking> getList(String username);
}
