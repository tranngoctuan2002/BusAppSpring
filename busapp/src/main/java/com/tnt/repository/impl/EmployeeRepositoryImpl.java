/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tnt.repository.impl;

import com.tnt.pojo.Customer;
import com.tnt.pojo.Employee;
import com.tnt.repository.EmployeeRepository;
import com.tnt.repository.UserRepository;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Employee> findEmployee(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root r = q.from(Employee.class);
        q.select(r);

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateEmployee(Employee emp) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (emp.getId() == null) {
                s.save(emp);
            } else {
                s.update(emp);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee findEmployeeById(int id) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root r = q.from(Employee.class);
        q.select(r);

        q.where(b.equal(r.get("id"), id));

        Query query = s.createQuery(q);

        return (Employee) query.getSingleResult();
    }

    @Override
    public boolean deleteEmployee(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Employee p = this.findEmployeeById(id);

        try {
            s.delete(p);
            this.userRepo.deleteUser(p.getUserId().getId());
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
