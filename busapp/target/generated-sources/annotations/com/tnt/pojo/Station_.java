package com.tnt.pojo;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import com.tnt.pojo.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-16T13:23:21")
@StaticMetamodel(Station.class)
public class Station_ { 

    public static volatile SingularAttribute<Station, Districts> districtCode;
    public static volatile SetAttribute<Station, Route> routeSet1;
    public static volatile SingularAttribute<Station, String> street;
    public static volatile SingularAttribute<Station, Provinces> provinceCode;
    public static volatile SingularAttribute<Station, String> name;
    public static volatile SingularAttribute<Station, Integer> id;
    public static volatile SetAttribute<Station, Route> routeSet;

}