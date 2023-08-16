/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.Station;
import com.tnt.repository.StationRepository;
import com.tnt.services.StationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class StationServiceImpl implements StationService{

    @Autowired
    private StationRepository repo;
    
    @Override
    public List<Station> findAllStations(Map<String, String> params) {
        return this.repo.findAllStations(params);
    }

    @Override
    public Station findStationById(int id) {
        return this.repo.findStationById(id);
    }

    @Override
    public boolean addOrUpdateStaion(Station station) {
        return this.repo.addOrUpdateStaion(station);
    }
    
}
