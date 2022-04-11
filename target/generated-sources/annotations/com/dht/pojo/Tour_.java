package com.dht.pojo;

import com.dht.pojo.Booking;
import com.dht.pojo.Comment;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-10T20:25:06")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile ListAttribute<Tour, Comment> commentList;
    public static volatile SingularAttribute<Tour, String> image;
    public static volatile SingularAttribute<Tour, BigDecimal> price;
    public static volatile ListAttribute<Tour, Booking> bookingList;
    public static volatile SingularAttribute<Tour, String> name;
    public static volatile SingularAttribute<Tour, String> description;
    public static volatile SingularAttribute<Tour, Integer> id;

}