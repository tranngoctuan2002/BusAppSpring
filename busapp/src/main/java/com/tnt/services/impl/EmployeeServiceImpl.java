/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tnt.configs.CloudinaryConfig;
import com.tnt.pojo.Employee;
import com.tnt.repository.EmployeeRepository;
import com.tnt.services.EmployeeService;
import java.io.IOException;
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
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private SimpleDateFormat formater;
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Employee> findEmployee(Map<String, String> params) {
        return this.repo.findEmployee(params);
    }

    @Override
    public boolean addOrUpdateEmployee(Employee emp) {
        if (!emp.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(emp.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                emp.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//        try {
//            emp.setBirth(formater.parse(emp.getBirth()));
//        } catch (ParseException ex) {
//            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return this.repo.addOrUpdateEmployee(emp);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return this.repo.findEmployeeById(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.repo.deleteEmployee(id);
    }

}
