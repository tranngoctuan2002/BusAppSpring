/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Employee;
import com.tnt.pojo.Station;
import com.tnt.repository.StationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class StationRepositoryImpl implements StationRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Station> findAllStations(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Station> q = b.createQuery(Station.class);
        Root r = q.from(Station.class);
        q.select(r);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            
            String province = params.get("province");
            if(province != null && !province.isEmpty()){
                predicates.add(b.equal(r.get("provinceCode").get("code"), province));
            }
            
            
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Station findStationById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Station.class, id);
    }

    @Override
    public boolean addOrUpdateStaion(Station station) {
        Session s = factory.getObject().getCurrentSession();
        try {
            if (station.getId() == null) {
                s.save(station);
            } else {
                s.update(station);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
