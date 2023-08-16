/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import java.util.List;

/**
 *
 * @author PC
 */
public interface LocationRepository {
    List<Provinces> findAllProvinces();
    List<Districts> findDistrictsByProvinces(String code);
}
