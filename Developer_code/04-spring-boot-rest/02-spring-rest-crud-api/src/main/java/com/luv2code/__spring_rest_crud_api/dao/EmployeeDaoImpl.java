package com.luv2code.__spring_rest_crud_api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.__spring_rest_crud_api.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee> findAll() {
		List<Employee> resultList = manager.createQuery("From Employee ", Employee.class).getResultList();
		return resultList;
	}

	@Override
	public Employee findById(int employeeId) {

		return manager.find(Employee.class, employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee employeeData = manager.merge(employee);
		return employeeData;
	}

	@Override
	public void deleteById(int employeeId) {
		Employee employee = manager.find(Employee.class, employeeId);
		manager.remove(employee);
	}

}
