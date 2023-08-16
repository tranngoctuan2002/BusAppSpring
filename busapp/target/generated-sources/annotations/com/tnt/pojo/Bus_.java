package com.tnt.pojo;

import com.tnt.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-16T13:23:21")
@StaticMetamodel(Bus.class)
public class Bus_ { 

    public static volatile SingularAttribute<Bus, Integer> seat;
    public static volatile SingularAttribute<Bus, String> licensePlate;
    public static volatile SetAttribute<Bus, Trip> tripSet;
    public static volatile SingularAttribute<Bus, Integer> id;

}