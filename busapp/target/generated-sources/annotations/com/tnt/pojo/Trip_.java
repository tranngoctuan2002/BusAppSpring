package com.tnt.pojo;

import com.tnt.pojo.Bill;
import com.tnt.pojo.Bus;
import com.tnt.pojo.Employee;
import com.tnt.pojo.Route;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-16T13:23:21")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Bus> bus;
    public static volatile SingularAttribute<Trip, Route> route;
    public static volatile SingularAttribute<Trip, Double> totalPrice;
    public static volatile SingularAttribute<Trip, Date> dayOfDeparture;
    public static volatile SetAttribute<Trip, Bill> billSet;
    public static volatile SingularAttribute<Trip, Integer> id;
    public static volatile SingularAttribute<Trip, Date> timeOfDeparture;
    public static volatile SingularAttribute<Trip, Employee> employee;

}