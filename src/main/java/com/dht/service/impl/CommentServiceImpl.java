/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Comment;
import com.dht.repository.CommentRepository;
import com.dht.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public List<Comment> getComment(Integer id) {
        return commentRepository.getComment(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }
    
}
