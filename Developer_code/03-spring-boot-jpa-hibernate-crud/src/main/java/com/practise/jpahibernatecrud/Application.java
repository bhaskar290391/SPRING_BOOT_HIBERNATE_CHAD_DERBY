package com.practise.jpahibernatecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practise.jpahibernatecrud.dao.StudentDao;
import com.practise.jpahibernatecrud.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner test(StudentDao studentDao) {
		
		return runner->{

			//createStudentData(studentDao);
			//createMultipleStudent(studentDao);
			//findById(studentDao);
			//findAllStudents(studentDao);
			//findBylastName(studentDao);
			//updateAllStudent(studentDao);
			//deleteById(studentDao);
			deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDao studentDao) {
		studentDao.deleteAllStudent();
		
	}

	private void deleteById(StudentDao studentDao) {
		studentDao.deleteStudentById(2);;
		
	}

	private void updateAllStudent(StudentDao studentDao) {
		studentDao.updateAllStudent();
		
		
		
	}

	private void findBylastName(StudentDao studentDao) {
		System.out.println(studentDao.findByLastName("Mudaliyar"));
	}

	private void findAllStudents(StudentDao studentDao) {
		System.out.println(studentDao.findAllStudent());		
	}

	private void findById(StudentDao studentDao) {
		System.out.println(studentDao.findStudentById(2));
		
	}

	private void createMultipleStudent(StudentDao studentDao) {
		Student student=new Student("bhaskar1", "mudaliyar1", "maddy1@gmail.com");
		Student student1=new Student("bhaskar2", "mudaliyar2", "maddy2@gmail.com");
		Student student2=new Student("bhaskar3", "mudaliyar3", "maddy3@gmail.com");
		studentDao.save(student);
		studentDao.save(student1);
		studentDao.save(student2);
	}

	private void createStudentData(StudentDao studentDao) {
		Student student=new Student("bhaskar", "mudaliyar", "maddy@gmail.com");
		studentDao.save(student);
	}

}
