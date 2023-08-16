/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Bus;
import com.tnt.pojo.Employee;
import com.tnt.pojo.Route;
import com.tnt.pojo.Trip;
import com.tnt.services.BusService;
import com.tnt.services.EmployeeService;
import com.tnt.services.RouteService;
import com.tnt.services.TripService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
public class TripController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BusService busService;
    @Autowired
    private TripService tripService;

    @RequestMapping("/trip")
    public String route(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("trips", this.tripService.findAllTrips(params));
        return "trip";
    }

    @GetMapping("/trip/details")
    public String details(Model model) {
        Trip tr = new Trip();

        Map<String, List> attr = new HashMap<>();
        attr.put("routes", this.routeService.findAllRoutes(null));
        attr.put("driver", this.employeeService.findEmployee(null));
        attr.put("buses", this.busService.findAllBuses());

        model.addAttribute("trip", tr);
        model.addAttribute("attr", attr);
        return "tripDetails";
    }

    @GetMapping("trip/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("trip", this.tripService.findTripById(id));
        Map<String, List> attr = new HashMap<>();
        attr.put("routes", this.routeService.findAllRoutes(null));
        attr.put("driver", this.employeeService.findEmployee(null));
        attr.put("buses", this.busService.findAllBuses());
        model.addAttribute("attr", attr);
        return "tripDetails";
    }
    
    @PostMapping("trip/details")
    public String add(@ModelAttribute(value="trip") Trip trip){
        if(this.tripService.addOrUpdateTrip(trip))
            return "redirect:/trip";
        return "tripDetails";
    }
}
