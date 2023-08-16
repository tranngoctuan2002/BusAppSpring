/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.services;

import com.tnt.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author PC
 */
public interface UserServices extends UserDetailsService {

    User getUserByUsername(String username);

    boolean AddOrUpdateUser(User user);

    User findUserById(int id);
    
    boolean deleteUser(int id);
}
