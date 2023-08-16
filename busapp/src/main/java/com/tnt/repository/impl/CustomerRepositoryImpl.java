/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Customer;
import com.tnt.repository.CustomerRepository;
import java.util.List;
import java.util.Map;
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
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Customer> findCustomers(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Customer> q = b.createQuery(Customer.class);
        Root r = q.from(Customer.class);
        q.select(r);

        Query query = s.createQuery(q);

        return query.getResultList();

    }

    @Override
    public Customer findCustomerById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Customer.class, id);
    }

    @Override
    public boolean AddOrUpdateCustomer(Customer customer) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (customer.getId() == null) {
                s.save(customer);
            } else {
                s.update(customer);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
