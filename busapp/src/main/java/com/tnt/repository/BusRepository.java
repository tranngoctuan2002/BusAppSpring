/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Bus;
import java.util.List;

/**
 *
 * @author PC
 */
public interface BusRepository {
    List<Bus> findAllBuses();
    Bus findBusById(int id);
    boolean addOrUpdateBus(Bus bus);
    boolean deleteBus(int id);
}
