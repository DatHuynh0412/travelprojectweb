/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.User;

/**
 *
 * @author huynh
 */
public interface UserRepository {
    boolean addUser(User user);
    User getUserByUsername (String username);
}
