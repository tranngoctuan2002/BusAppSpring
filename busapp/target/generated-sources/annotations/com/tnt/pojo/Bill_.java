package com.tnt.pojo;

import com.tnt.pojo.Customer;
import com.tnt.pojo.Employee;
import com.tnt.pojo.Trip;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-16T13:23:21")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, String> seat;
    public static volatile SingularAttribute<Bill, Date> acquiredDate;
    public static volatile SingularAttribute<Bill, Trip> trip;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Integer> state;
    public static volatile SingularAttribute<Bill, Employee> employee;
    public static volatile SingularAttribute<Bill, Customer> customer;

}