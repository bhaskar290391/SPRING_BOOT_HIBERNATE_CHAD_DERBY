package com.luv2code.restcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.restcrud.entity.Student;


@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudentList() {
		
		List< Student> theStudent=new ArrayList<>();
		theStudent.add(new Student("bhaskar", "mudaliyar"));
		theStudent.add(new Student("Maddy", "mudaliyar"));
		theStudent.add(new Student("Kanishk", "mudaliyar"));
		
		return theStudent;
	}
	
}
