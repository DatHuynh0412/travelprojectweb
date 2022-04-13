package com.dht.pojo;

import com.dht.pojo.News;
import com.dht.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-13T20:47:51")
@StaticMetamodel(Newscomment.class)
public class Newscomment_ { 

    public static volatile SingularAttribute<Newscomment, News> newsId;
    public static volatile SingularAttribute<Newscomment, String> comment;
    public static volatile SingularAttribute<Newscomment, Integer> id;
    public static volatile SingularAttribute<Newscomment, User> userId;

}