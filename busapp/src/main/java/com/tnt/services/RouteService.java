/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.services;

import com.tnt.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface RouteService {

    List<Route> findAllRoutes(Map<String, String> params);

    Route findRouteById(int id);

    boolean addOrUpdateRoute(Route route);
}
