package com.luv2code.__spring_rest_crud_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.__spring_rest_crud_api.entity.Employee;

public interface EmployeeDao  extends JpaRepository<Employee, Integer>{

}
