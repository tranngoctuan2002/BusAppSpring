/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Districts;
import com.tnt.pojo.Employee;
import com.tnt.pojo.Provinces;
import com.tnt.repository.LocationRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Provinces> findAllProvinces() {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Provinces> q = b.createQuery(Provinces.class);
        Root r = q.from(Provinces.class);
        q.select(r);
        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Districts> findDistrictsByProvinces(String code) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Districts> q = b.createQuery(Districts.class);
        Root r = q.from(Districts.class);
     
        q.where(b.like(r.get("provinceCode").get("code"), code));
        
        q.select(r);
        Query query = s.createQuery(q);

        return query.getResultList();
    }

}
