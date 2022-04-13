package com.dht.pojo;

import com.dht.pojo.Newscomment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-13T20:47:51")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile ListAttribute<News, Newscomment> newscommentList;
    public static volatile SingularAttribute<News, String> name;
    public static volatile SingularAttribute<News, String> description;
    public static volatile SingularAttribute<News, Integer> id;

}