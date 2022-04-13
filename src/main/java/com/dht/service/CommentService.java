/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

import com.dht.pojo.Comment;
import java.util.List;

/**
 *
 * @author huynh
 */
public interface CommentService {
    List<Comment> getComment(Integer id);
    void addComment(Comment comment);
}
