/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Trip;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface TripRepository {
    List<Trip> findAllTrips(Map<String, String> params);
    Trip findTripById(int id);
    boolean addOrUpdateTrip(Trip trip);
    boolean deleteTrip(int id);
}
