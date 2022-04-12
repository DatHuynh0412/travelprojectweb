package com.dht.pojo;

import com.dht.pojo.Tour;
import com.dht.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-12T16:35:29")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Tour> tourId;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, Integer> adultTicket;
    public static volatile SingularAttribute<Booking, Integer> childTicket;
    public static volatile SingularAttribute<Booking, User> userId;

}