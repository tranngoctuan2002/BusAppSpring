/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Route;
import com.tnt.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@ControllerAdvice
@RequestMapping("/api")
public class ApiRouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping(value="/route/{id}")
    public Route findRoutes(@PathVariable(value = "id") int id) {
        Route r = this.routeService.findRouteById(id);
        return r;
    }

}
