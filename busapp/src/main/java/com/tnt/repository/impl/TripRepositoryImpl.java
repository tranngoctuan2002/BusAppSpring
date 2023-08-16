/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Employee;
import com.tnt.pojo.Trip;
import com.tnt.repository.TripRepository;
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
public class TripRepositoryImpl implements TripRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Trip> findAllTrips(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Trip> q = b.createQuery(Trip.class);
        Root r = q.from(Trip.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {
            String departure_p = params.get("departure_p");
            String destination_p = params.get("destination_p");
            if (departure_p != null && !departure_p.isEmpty()) {
                predicates.add(b.equal(r.get("route").get("departure").get("provinceCode").get("code"), departure_p));
                predicates.add(b.equal(r.get("route").get("destination").get("provinceCode").get("code"), destination_p));
            }
        }

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Trip findTripById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Trip.class, id);
    }

    @Override
    public boolean addOrUpdateTrip(Trip trip) {
        Session s = factory.getObject().getCurrentSession();
        try {
            if (trip.getId() == null) {
                s.save(trip);
            } else {
                s.update(trip);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrip(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
