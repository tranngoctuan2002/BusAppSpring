/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Customer;
import com.tnt.pojo.User;
import com.tnt.services.CustomerService;
import com.tnt.services.EmployeeService;
import com.tnt.services.UserServices;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class CustomerController {

    @Autowired
    private CustomerService cusService;

    @Autowired
    private UserServices userService;

    @RequestMapping("/customer")
    public String customer(Model model) {
        model.addAttribute("customers", this.cusService.findCustomers(null));
        return "customer";
    }

    @GetMapping("/customer/add")
    public String list(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerDetails";
    }

    @GetMapping("/customer/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Customer customer = this.cusService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customerDetails";
    }

    @PostMapping("/customer/add")
    public String add(@ModelAttribute(value = "customer") Customer c,
            BindingResult rs) {

//        if (!rs.hasErrors()) {
        if (c.getUserId().getId() == null) {
            User u = new User();
            u.setUsername(c.getUserId().getUsername());
            u.setPassword("customer");
            u.setRole(User.ROLE.CUSTOMER.toString());

            this.userService.AddOrUpdateUser(u);
            u = this.userService.getUserByUsername(u.getUsername());
            c.setUserId(u);
        }

        if (this.cusService.AddOrUpdateCustomer(c) == true) {
            return "redirect:/customer";
        } else {
            return "customerDetails";
        }

//        return "index";
    }
}
