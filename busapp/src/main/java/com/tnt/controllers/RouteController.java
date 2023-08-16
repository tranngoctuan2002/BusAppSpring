/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import com.tnt.pojo.Route;
import com.tnt.pojo.Station;
import com.tnt.services.LocationService;
import com.tnt.services.RouteService;
import com.tnt.services.StationService;
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
public class RouteController {

    @Autowired
    private LocationService locaService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private StationService stationService;

    @RequestMapping("/route")
    public String route(Model model, @RequestParam Map<String, String> params) {
        List<Route> routes = this.routeService.findAllRoutes(params);
        model.addAttribute("routes", routes);
        return "route";
    }

    @GetMapping("/route/details")
    public String detail(Model model) {
        Route r = new Route();
        model.addAttribute("route", r);
        List<Provinces> p = locaService.findAllProvinces();
        model.addAttribute("provinces", p);
        return "routeDetails";
    }

    @GetMapping("/route/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Route r = this.routeService.findRouteById(id);
        model.addAttribute("route", r);

        List<Provinces> p = locaService.findAllProvinces();
        model.addAttribute("provinces", p);
        
        Map<String, String> param1 = new HashMap<>();
        param1.put("province", r.getDeparture().getProvinceCode().getCode());
        List<Station> station_departure = this.stationService.findAllStations(param1);
        model.addAttribute("departure_s", station_departure);
        
        Map<String, String> param2 = new HashMap<>();
        param2.put("province", r.getDestination().getProvinceCode().getCode());
        List<Station> station_destination = this.stationService.findAllStations(param2);
        model.addAttribute("destination_s", station_destination);

        return "routeDetails";
    }
    
    @PostMapping("/route/details")
    public String add(@ModelAttribute(value = "route") Route route){
        if(this.routeService.addOrUpdateRoute(route))
            return "redirect:/route";
        return "routeDetails";
    }
}
