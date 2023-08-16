/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface RouteRepository {
    List<Route> findAllRoutes(Map<String, String> params);
    Route findRouteById(int id);
    boolean addOrUpdateRoute(Route route);
}
