package com.jpahibernate.advancemapping.oneToOneMapping;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpahibernate.advancemapping.oneToOneMapping.dao.AppDao;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Courses;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Review;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner(AppDao dao) {

		return runner -> {

			//saveCoursesAndReviews(dao);
			
			//retriveCourseAndReviews(dao);
			
			deleteCoursesById(dao);
		};
	}

	private void retriveCourseAndReviews(AppDao dao) {
		
	 Courses courseAndReviewByJoinFetch = dao.retrieveCourseAndReviewByJoinFetch(10);
	 
	 System.out.println("The courses ==>"+ courseAndReviewByJoinFetch);
	 
	 System.out.println("The reviws ==>"+ courseAndReviewByJoinFetch.getReviews());
	}

	private void saveCoursesAndReviews(AppDao dao) {
		
		Courses theCouse=new Courses("The pacman --how to score 1million points");
		theCouse.addReviews(new Review("Nice course"));
		theCouse.addReviews(new Review("excellent"));
		theCouse.addReviews(new Review("Poor Course"));
		dao.saveCourse(theCouse);
	}

	private void deleteCoursesById(AppDao dao) {

		dao.deleteCoursesById(10);
	}

	private void updateCoursesByid(AppDao dao) {
		Courses updateCourses = dao.updateCourses(10);
		System.out.println(updateCourses);
	}

	private void updateInstructorById(AppDao dao) {
		Instructor updateInstructor = dao.updateInstructor(1);
		System.out.println(updateInstructor);
	}

	private void findInstructorByJoinFetch(AppDao dao) {

		Instructor instructorByJoinFetch = dao.findInstructorByJoinFetch(1);
		System.out.println("instructorByJoinFetch==> " + instructorByJoinFetch);
		System.out.println("instructorByJoinFetch==> " + instructorByJoinFetch.getCourses());
	}

	private void findInstructorWithCourses(AppDao dao) {

		Instructor instructor = dao.findById(1);

		List<Courses> courseByInstructorId = dao.findCourseByInstructorId(instructor.getId());

		instructor.setCourses(courseByInstructorId);

		System.out.println("The courses is " + instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDao dao) {

		Instructor inst1 = new Instructor("Bhaksar", "mudaliyar", "bhaskar.mudaliyar@gmail.com");

		InstructorDetails detail = new InstructorDetails("bhaskar2", "cricket");

		inst1.setDetails(detail);

		Courses tempCourses = new Courses("Java T point");
		Courses tempCourses2 = new Courses("AWS");

		inst1.addCourses(tempCourses);
		inst1.addCourses(tempCourses2);
		dao.saveInstructor(inst1);

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
		Instructor inst1 = new Instructor("Bhaksar", "mudaliyar", "bhaskar.mudaliyar@gmail.com");
		Instructor inst2 = new Instructor("Bhaksar1", "mudaliyar1", "bhaskar1.mudaliyar1@gmail.com");

		InstructorDetails detail = new InstructorDetails("bhaskar", "singing");
		InstructorDetails detail2 = new InstructorDetails("bhaskar2", "cricket");

		inst1.setDetails(detail);
		inst2.setDetails(detail2);

		dao.saveInstructor(inst1);
		dao.saveInstructor(inst2);

	}
}
