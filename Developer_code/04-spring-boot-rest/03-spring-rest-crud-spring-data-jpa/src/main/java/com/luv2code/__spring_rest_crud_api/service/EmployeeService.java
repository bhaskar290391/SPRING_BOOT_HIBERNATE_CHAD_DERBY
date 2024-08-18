package com.luv2code.__spring_rest_crud_api.service;

import java.util.List;

import com.luv2code.__spring_rest_crud_api.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public Employee saveEmployee(Employee employee);

	public void deleteById(int employeeId);
}
