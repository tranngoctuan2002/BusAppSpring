/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import com.tnt.pojo.Station;
import com.tnt.services.LocationService;
import com.tnt.services.StationService;
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
public class StationController {

    @Autowired
    private LocationService locaService;

    @Autowired
    private StationService stationService;

    @RequestMapping("/station")
    public String station(Model model, @RequestParam Map<String, String> params) {
        List<Station> stations = this.stationService.findAllStations(params);
        model.addAttribute("stations", stations);
        return "station";
    }

    @GetMapping("/station/details")
    public String detail(Model model) {
        Station s = new Station();
        model.addAttribute("station", s);
        List<Provinces> provinces = locaService.findAllProvinces();
        model.addAttribute("provinces", provinces);
        return "stationDetails";
    }

    @GetMapping("/station/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Station s = this.stationService.findStationById(id);
        model.addAttribute("station", s);
        List<Provinces> provinces = locaService.findAllProvinces();
        model.addAttribute("provinces", provinces);
        List<Districts> districts = locaService.findDistrictsByProvinces(s.getProvinceCode().getCode());
        model.addAttribute("districts", districts);
        return "stationDetails";
    }

    @PostMapping("/station/details")
    public String add(@ModelAttribute(value = "station") Station station) {
        if (this.stationService.addOrUpdateStaion(station)) {
            return "redirect:/station";
        }
        return "stationDetails";
    }
}
