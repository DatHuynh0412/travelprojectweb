/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Booking;
import com.dht.pojo.Tour;
import com.dht.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynh
 */
@Repository
@Transactional
@PropertySource("classpath:info.properties")
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Autowired
    private Environment env;

    @Override
    public List<Tour> getTour(String kw, int page) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tour> q = b.createQuery(Tour.class);
        Root root = q.from(Tour.class);
        q.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q.where(p);
        }

        Query query = session.createQuery(q);
        
        int pageSize = Integer.parseInt(env.getProperty("info.page_size"));
        int start = (page - 1) * pageSize;
        
        query.setMaxResults(pageSize);
        query.setFirstResult(start);
        
        return query.getResultList();
    }

    @Override
    public Tour getTourById(Integer id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("select t from Tour t where id = "+id);
        return (Tour) q.getSingleResult();
    }

    @Override
    public void editTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.update(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.delete(tour);
    }

    @Override
    public void addTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.save(tour);
    }
    
    @Override
    public int countTours() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Tour");
        Object re = q.getSingleResult();
        
        return Integer.parseInt(re.toString());
    }

    @Override
    public boolean addOrUpdateTour(Tour t) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(t);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void bookingTour(Tour tour ,Booking booking) {
        
    }
}
