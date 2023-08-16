/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.Route;
import com.tnt.repository.RouteRepository;
import com.tnt.services.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository repo;

    @Override
    public Route findRouteById(int id) {
        return this.repo.findRouteById(id);
    }

    @Override
    public boolean addOrUpdateRoute(Route route) {
        return this.repo.addOrUpdateRoute(route);
    }

    @Override
    public List<Route> findAllRoutes(Map<String, String> params) {
        return this.repo.findAllRoutes(params);
    }

}
