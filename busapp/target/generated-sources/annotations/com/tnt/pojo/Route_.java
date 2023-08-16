package com.tnt.pojo;

import com.tnt.pojo.Station;
import com.tnt.pojo.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-16T13:23:21")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Double> price;
    public static volatile SingularAttribute<Route, Station> destination;
    public static volatile SetAttribute<Route, Trip> tripSet;
    public static volatile SingularAttribute<Route, Integer> id;
    public static volatile SingularAttribute<Route, Station> departure;

}