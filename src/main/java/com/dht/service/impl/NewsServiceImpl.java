/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.News;
import com.dht.repository.NewsRepository;
import com.dht.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepository;
    
    @Override
    public List<News> getNews() {
        return newsRepository.getNews();
    }

    @Override
    public News getNewsByid(Integer id) {
        return newsRepository.getNewsByid(id);
    }
    
}
