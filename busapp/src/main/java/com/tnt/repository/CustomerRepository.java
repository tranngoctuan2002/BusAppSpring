/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Customer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface CustomerRepository {
    List<Customer> findCustomers(Map<String, String> params);
    boolean AddOrUpdateCustomer(Customer customer);
    Customer findCustomerById(int id);
}
