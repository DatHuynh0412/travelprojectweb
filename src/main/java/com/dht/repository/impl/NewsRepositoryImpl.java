/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.News;
import com.dht.repository.NewsRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynh
 */
@Repository
@Transactional
public class NewsRepositoryImpl implements NewsRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    
    @Override
    public List<News> getNews() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("FROM News");
        
        return query.getResultList();
    }

    @Override
    public News getNewsByid(Integer id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        Query query = session.createQuery("FROM News Where id = "+id);
        
        return (News) query.getSingleResult();
    }
    
}
