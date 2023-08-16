/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.services;

import com.tnt.pojo.Employee;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface EmployeeService {
    List<Employee> findEmployee(Map<String, String> params);
    boolean addOrUpdateEmployee(Employee emp);
    Employee findEmployeeById(int id);
    boolean deleteEmployee(int id);
}
