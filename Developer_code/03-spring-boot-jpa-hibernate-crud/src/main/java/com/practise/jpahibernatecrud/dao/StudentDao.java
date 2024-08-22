package com.practise.jpahibernatecrud.dao;

import java.util.List;

import com.practise.jpahibernatecrud.entity.Student;

public interface StudentDao {

	public void save(Student student);
	
	public Student findStudentById(int id);
	
	public List<Student> findAllStudent();
	
	public List<Student> findByLastName(String lastName);
	
	public Student updateStudent(Student student);
	
	public int updateAllStudent();
	
	public void deleteStudentById(int id);
	
	public int deleteAllStudent();
	
	
}
