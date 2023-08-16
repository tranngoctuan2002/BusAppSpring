/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Employee;
import com.tnt.pojo.Route;
import com.tnt.pojo.Station;
import com.tnt.repository.RouteRepository;
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
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Route> findAllRoutes(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root rR = q.from(Route.class);

        q.select(rR);

        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {
            String departure_p = params.get("departure_p");
            String destination_p = params.get("destination_p");
            if (departure_p != null && !departure_p.isEmpty() && destination_p != null && !destination_p.isEmpty()) {
                predicates.add(b.equal(rR.get("departure").get("provinceCode").get("code"), departure_p));
                predicates.add(b.equal(rR.get("destination").get("provinceCode").get("code"), destination_p));
            }
        }

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Route findRouteById(int id) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root r = q.from(Route.class);
        q.select(r);

        q.where(b.equal(r.get("id"), id));

        Query query = s.createQuery(q);

        return (Route) query.getSingleResult();
    }

    @Override
    public boolean addOrUpdateRoute(Route route) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (route.getId() == null) {
                s.save(route);
            } else {
                s.update(route);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
