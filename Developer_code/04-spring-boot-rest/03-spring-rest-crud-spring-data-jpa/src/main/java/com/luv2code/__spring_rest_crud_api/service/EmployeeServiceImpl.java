package com.luv2code.__spring_rest_crud_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.__spring_rest_crud_api.dao.EmployeeDao;
import com.luv2code.__spring_rest_crud_api.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeRepo;
	
	@Override
	public List<Employee> findAll() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> data = employeeRepo.findById(employeeId);
		if(data.isEmpty()) {
			throw new RuntimeException("Employee Not Found for id :"+employeeId);
		}else {
			return data.get();
		}
	
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepo.deleteById(employeeId);
	}

}
