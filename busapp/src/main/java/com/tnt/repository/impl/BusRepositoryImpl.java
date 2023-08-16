/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Bus;
import com.tnt.pojo.Employee;
import com.tnt.repository.BusRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class BusRepositoryImpl implements BusRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Bus> findAllBuses() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Bus> q = b.createQuery(Bus.class);
        Root r = q.from(Bus.class);
        q.select(r);

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Bus findBusById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Bus.class, id);
    }

    @Override
    public boolean addOrUpdateBus(Bus bus) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (bus.getId() == null) {
                s.save(bus);
            } else {
                s.update(bus);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBus(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Bus p = this.findBusById(id);

        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
