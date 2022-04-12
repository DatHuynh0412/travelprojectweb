/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Booking;
import com.dht.pojo.Tour;
import com.dht.repository.StatsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    
    @Override
    public List<Object[]> StatList() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rt = q.from(Tour.class);
        Root bk = q.from(Booking.class);
        
        q.where(b.equal(rt.get("id"), bk.get("tourId")));
        q.groupBy(bk.get("tourId"));
        q.multiselect(rt.get("name"),b.count(bk.get("userId")));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
