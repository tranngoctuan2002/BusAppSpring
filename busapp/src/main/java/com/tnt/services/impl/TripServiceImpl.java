/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.Trip;
import com.tnt.repository.TripRepository;
import com.tnt.services.TripService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class TripServiceImpl implements TripService{

    @Autowired
    private TripRepository repo;
    
    @Override
    public List<Trip> findAllTrips(Map<String, String> params) {
        return this.repo.findAllTrips(params);
    }

    @Override
    public Trip findTripById(int id) {
        return this.repo.findTripById(id);
    }

    @Override
    public boolean addOrUpdateTrip(Trip trip) {
        return this.repo.addOrUpdateTrip(trip);
    }

    @Override
    public boolean deleteTrip(int id) {
        return true;
    }
    
}
