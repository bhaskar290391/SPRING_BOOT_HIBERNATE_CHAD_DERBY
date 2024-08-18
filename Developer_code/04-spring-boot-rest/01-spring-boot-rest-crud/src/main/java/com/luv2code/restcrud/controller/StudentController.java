package com.luv2code.restcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.restcrud.entity.Student;
import com.luv2code.restcrud.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> theStudent;

	@PostConstruct
	public void loadData() {
		theStudent = new ArrayList<>();
		theStudent.add(new Student("bhaskar", "mudaliyar"));
		theStudent.add(new Student("Maddy", "mudaliyar"));
		theStudent.add(new Student("Kanishk", "mudaliyar"));
	}

	@GetMapping("/students")
	public List<Student> getStudentList() {

		return theStudent;
	}
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudentList(@PathVariable int studentId) {

		if(studentId >= theStudent.size() || studentId<0)
			throw new StudentNotFoundException("Student Not found Exception Id:"+studentId);
		return theStudent.get(studentId);
	}

}
