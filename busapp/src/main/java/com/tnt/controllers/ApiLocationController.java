/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.controllers;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Provinces;
import com.tnt.services.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class ApiLocationController {
    
    @Autowired
    private LocationService locaService;
    
    @GetMapping("/location/d/{code}")
    @CrossOrigin
    public ResponseEntity<List<Districts>> getDistricsByProvince(@PathVariable(value = "code") String code){ 
        return new ResponseEntity<>(this.locaService.findDistrictsByProvinces(code), HttpStatus.OK);
    }
    
    @GetMapping("/provinces")
    @CrossOrigin
    public ResponseEntity<List<Provinces>> getProvinces(){
        return new ResponseEntity<>(this.locaService.findAllProvinces(), HttpStatus.OK);
    }

}
