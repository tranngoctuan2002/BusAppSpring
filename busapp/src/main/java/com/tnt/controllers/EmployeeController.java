/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Employee;
import com.tnt.pojo.User;
import com.tnt.services.EmployeeService;
import com.tnt.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@ControllerAdvice
public class EmployeeController {

    @Autowired
    private EmployeeService empService;
    @Autowired
    private UserServices userService;

    @RequestMapping("/employee")
    public String employee(Model model) {
        model.addAttribute("employees", this.empService.findEmployee(null));
        return "employee";
    }

    @GetMapping("/employee/details")
    public String list(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "employeeDetails";
    }

    @GetMapping("/employee/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Employee emp = empService.findEmployeeById(id);
        model.addAttribute("employee", emp);
        return "employeeDetails";
    }

    @PostMapping("/employee/details")
    public String add(@ModelAttribute(value = "employee") Employee emp,
            BindingResult rs) {
        
//        if (!rs.hasErrors()) {
        if (emp.getUserId().getId() == null) {
            User u = new User();
            u.setUsername(emp.getUserId().getUsername());
            u.setPassword(emp.getPhone());
            u.setRole(emp.getUserId().getRole());

            this.userService.AddOrUpdateUser(u);
            u = this.userService.getUserByUsername(u.getUsername());
            emp.setUserId(u);
        }
        
        Employee e = emp;

        if (this.empService.addOrUpdateEmployee(emp) == true && this.userService.AddOrUpdateUser(emp.getUserId()))
            return "redirect:/employee/";
        return "employeeDetails";

//        return "employeeDetails";
        

    }
}
