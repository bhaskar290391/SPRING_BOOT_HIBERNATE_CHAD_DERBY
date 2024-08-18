package com.luv2code.__spring_rest_crud_api.dao;

import java.util.List;

import com.luv2code.__spring_rest_crud_api.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public Employee saveEmployee(Employee employee);

	public void deleteById(int employeeId);

}
