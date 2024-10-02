package com.jpahibernate.advancemapping.oneToOneMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpahibernate.advancemapping.oneToOneMapping.dao.AppDao;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner(AppDao dao) {

		return runner -> {

			//createInstuctor(dao);
			//findInstructorById(dao);
			//deleteInstructorByid(dao);
			//findInstructorDetailsById(dao);
			deleteInstructorDetailById(dao);
		};
	}

	private void deleteInstructorDetailById(AppDao dao) {
		
		dao.deleteInstructotDetailById(2);
	}

	private void findInstructorDetailsById(AppDao dao) {
		
		System.out.println(dao.findInstructorDetailById(2).getInstructor());
		
	}

	private void deleteInstructorByid(AppDao dao) {
		dao.deleteByInstructorId(1);

	}

	private void findInstructorById(AppDao dao) {
		System.out.println(dao.findById(1));

	}

	private void createInstuctor(AppDao dao) {
		Instructor inst1=new Instructor("Bhaksar", "mudaliyar", "bhaskar.mudaliyar@gmail.com");
		Instructor inst2=new Instructor("Bhaksar1", "mudaliyar1", "bhaskar1.mudaliyar1@gmail.com");
		
		InstructorDetails detail=new InstructorDetails("bhaskar", "singing");
		InstructorDetails detail2=new InstructorDetails("bhaskar2", "cricket");
		
		
		inst1.setDetails(detail);
		inst2.setDetails(detail2);
		
		dao.saveInstructor(inst1);
		dao.saveInstructor(inst2);
		
	}
}
