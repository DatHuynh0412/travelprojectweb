/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Comment;
import com.dht.pojo.Newscomment;
import com.dht.repository.CommentRepository;
import com.dht.repository.NewsCommentRepository;
import com.dht.service.NewscommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */
@Service
public class NewscommentServiceImpl implements NewscommentService{
     @Autowired
    private NewsCommentRepository commentRepository;
    
    @Override
    public List<Newscomment> getComment(Integer id) {
        return commentRepository.getComment(id);
    }

    @Override
    public void addComment(Newscomment comment) {
        commentRepository.addComment(comment);
    }
    
}
