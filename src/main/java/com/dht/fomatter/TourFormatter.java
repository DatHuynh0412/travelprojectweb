/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.fomatter;

import com.dht.pojo.Tour;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class TourFormatter implements Formatter<Tour> {

    @Override
    public String print(Tour t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Tour parse(String id, Locale locale) throws ParseException {
        Tour t = new Tour();
        t.setId(Integer.parseInt(id));
        return t;
    }
    
}
