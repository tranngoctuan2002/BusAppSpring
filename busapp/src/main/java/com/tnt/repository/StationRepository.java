/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Station;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface StationRepository {
    List<Station> findAllStations(Map<String, String> params);
    Station findStationById(int id);
    boolean addOrUpdateStaion(Station station);
}
