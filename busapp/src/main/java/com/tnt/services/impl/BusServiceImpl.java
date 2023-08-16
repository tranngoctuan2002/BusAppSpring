/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.Bus;
import com.tnt.repository.BusRepository;
import com.tnt.services.BusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private BusRepository repo;
    
    @Override
    public List<Bus> findAllBuses() {
        return this.repo.findAllBuses();
    }

    @Override
    public Bus findBusById(int id) {
        return this.repo.findBusById(id);
    }

    @Override
    public boolean addOrUpdateBus(Bus bus) {
        return this.repo.addOrUpdateBus(bus);
    }

    @Override
    public boolean deleteBus(int id) {
        return this.repo.deleteBus(id);
    }
    
}
