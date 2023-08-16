/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Bus;
import com.tnt.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class BusController {
    
    @Autowired
    private BusService busService;
    
    @RequestMapping("/buses")
    public String bus(Model model){
        model.addAttribute("buses", this.busService.findAllBuses());
        return "bus";
    }
    
    @GetMapping("/buses/details")
    public String detail(Model model){
        Bus b = new Bus();
        model.addAttribute("bus", b);
        return "busDetails";
    }
    
    @GetMapping("/buses/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id){
        Bus b = busService.findBusById(id);
        model.addAttribute("bus", b);
        return "busDetails";
    }
    
    @PostMapping("/buses/details")
    public String add(@ModelAttribute(value = "bus") Bus bus){
        if(this.busService.addOrUpdateBus(bus))
            return "redirect:/buses";
        
        return "busDetails";
    }
}
