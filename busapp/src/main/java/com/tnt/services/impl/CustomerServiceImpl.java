/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tnt.pojo.Customer;
import com.tnt.repository.CustomerRepository;
import com.tnt.services.CustomerService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private SimpleDateFormat formatter;

    @Override
    public List<Customer> findCustomers(Map<String, String> params) {
        return this.repo.findCustomers(params);
    }

    @Override
    public boolean AddOrUpdateCustomer(Customer customer) {
        if (!customer.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(customer.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                customer.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        try {
//            customer.setBirth(formatter.parse(formatter.format(customer.getBirth())));
//        } catch (ParseException ex) {
//            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }


        return this.repo.AddOrUpdateCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return this.repo.findCustomerById(id);
    }

}
