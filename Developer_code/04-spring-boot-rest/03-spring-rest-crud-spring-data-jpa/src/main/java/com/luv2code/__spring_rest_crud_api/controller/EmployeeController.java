package com.luv2code.__spring_rest_crud_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.__spring_rest_crud_api.entity.Employee;
import com.luv2code.__spring_rest_crud_api.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		return service.findById(employeeId);
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {

		Employee employee = service.findById(employeeId);

		if (employee != null) {
			service.deleteById(employeeId);
		} else {
			throw new RuntimeException("Employee not found for user Id :" + employeeId);
		}
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employye) {

		employye.setId(0);

		return service.saveEmployee(employye);
	}

	@PutMapping("/employees")
	public Employee updateEmployees(@RequestBody Employee employye) {

		return service.saveEmployee(employye);
	}
}
