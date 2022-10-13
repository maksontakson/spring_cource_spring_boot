package com.example.spring_cource_spring_boot.dao;


import com.example.spring_cource_spring_boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmps = session.createQuery("from Employee", Employee.class).getResultList();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmps = query.getResultList();
        return allEmps;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
          Employee newEmployee = entityManager.merge(employee);
          employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " + "where id =: employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

          Query query = entityManager.createQuery("delete from Employee " + "where id =: employeeId");
          query.setParameter("employeeId", id);
          query.executeUpdate();
    }
}
