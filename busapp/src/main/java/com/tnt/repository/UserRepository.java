/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tnt.repository;

import com.tnt.pojo.User;

/**
 *
 * @author PC
 */
public interface UserRepository {
    public User getUserByUsername(String username);
    boolean AddOrUpdateUser(User user);
    User findUserById(int id);
    boolean deleteUser(int id);
}
