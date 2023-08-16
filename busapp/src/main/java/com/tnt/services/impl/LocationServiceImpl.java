/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import com.tnt.repository.LocationRepository;
import com.tnt.services.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class LocationServiceImpl implements LocationService{
    
    @Autowired
    private LocationRepository repo;

    @Override
    public List<Provinces> findAllProvinces() {
        return this.repo.findAllProvinces();
    }

    @Override
    public List<Districts> findDistrictsByProvinces(String code) {
        return this.repo.findDistrictsByProvinces(code);
    }
    
}
