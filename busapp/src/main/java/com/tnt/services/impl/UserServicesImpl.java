/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.services.impl;

import com.tnt.pojo.User;
import com.tnt.repository.UserRepository;
import com.tnt.services.UserServices;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository repo;
   

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
        User u = this.repo.getUserByUsername(string);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole().toString()));
        
        return  new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.repo.getUserByUsername(username);
    }

    @Override
    public boolean AddOrUpdateUser(User user) {
        return this.repo.AddOrUpdateUser(user);
    }

    @Override
    public User findUserById(int id) {
        return this.repo.findUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.repo.deleteUser(id);
    }
}
