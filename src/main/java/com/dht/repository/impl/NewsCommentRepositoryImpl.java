/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Comment;
import com.dht.pojo.Newscomment;
import com.dht.repository.NewsCommentRepository;
import com.dht.service.UserService;
import java.util.List;
import javax.persistence.Query;
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
public class NewsCommentRepositoryImpl implements NewsCommentRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Autowired
    private UserService userservice;


    @Override
    public List<Newscomment> getComment(Integer id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();     
        Query query = session.createQuery("FROM Newscomment Where news_id="+id);
        return query.getResultList();
    }

    @Override
    public void addComment(Newscomment comment) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession(); 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        comment.setUserId(userservice.getUserByUsername(auth.getName()));
        session.save(comment);
    } 
}
