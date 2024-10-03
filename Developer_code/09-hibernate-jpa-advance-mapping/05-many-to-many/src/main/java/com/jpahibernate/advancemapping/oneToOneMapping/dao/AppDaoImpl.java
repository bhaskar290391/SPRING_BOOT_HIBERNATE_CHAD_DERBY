package com.jpahibernate.advancemapping.oneToOneMapping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpahibernate.advancemapping.oneToOneMapping.entity.Courses;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Students;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDaoImpl implements AppDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public void saveInstructor(Instructor data) {
		manager.persist(data);

	}

	@Override
	public Instructor findById(int id) {
		Instructor instructor = manager.find(Instructor.class, id);
		return instructor;
	}

	@Override
	public InstructorDetails findInstructorDetailById(int id) {
		return manager.find(InstructorDetails.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructotDetailById(int id) {

		InstructorDetails details = manager.find(InstructorDetails.class, id);
		details.getInstructor().setDetails(null);
		manager.remove(details);
	}

	@Override
	public List<Courses> findCourseByInstructorId(int id) {

		TypedQuery<Courses> query = manager.createQuery("from Courses where instructor.id=:data", Courses.class);
		query.setParameter("data", id);
		return query.getResultList();
	}

	@Override
	public Instructor findInstructorByJoinFetch(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query = manager.createQuery(
				"select i from Instructor i " + " join fetch i.courses " + " join fetch i.details where i.id=:data",
				Instructor.class);

		query.setParameter("data", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void deleteByInstructorId(int id) {
		Instructor instructor = manager.find(Instructor.class, id);

		List<Courses> coursesList = instructor.getCourses();

		for (Courses courses : coursesList) {
			courses.setInstructor(null);
		}
		manager.remove(instructor);

	}

	@Override
	@Transactional
	public Instructor updateInstructor(int id) {

		Instructor instructor = manager.find(Instructor.class, id);

		instructor.setLastName("Maddy");

		return manager.merge(instructor);

	}

	@Override
	@Transactional
	public Courses updateCourses(int id) {

		Courses courses = manager.find(Courses.class, id);
		courses.setTitle("Enjoy the new things");
		return manager.merge(courses);
	}

	@Override
	@Transactional
	public void deleteCoursesById(int id) {
		Courses courses = manager.find(Courses.class, id);
		manager.remove(courses);

	}

	@Override
	@Transactional
	public void saveCourse(Courses theCouse) {
		manager.persist(theCouse);

	}

	@Override
	public Courses retrieveCourseAndReviewByJoinFetch(int id) {

		TypedQuery<Courses> query = manager
				.createQuery("select i from Courses i " + " join fetch i.reviews  where i.id=:data", Courses.class);

		query.setParameter("data", id);
		return query.getSingleResult();
	}

	@Override
	public Courses fetchCourseAndStudentByCourseId(int courseId) {
		TypedQuery<Courses> query = manager
				.createQuery("select i from Courses i " + " join fetch i.students  where i.id=:data", Courses.class);

		query.setParameter("data", courseId);
		return query.getSingleResult();
	}

	@Override
	public Students fetchStudentAndCourseByStudentId(int studentsId) {
		TypedQuery<Students> query = manager
				.createQuery("select i from Students i " + " join fetch i.courses  where i.id=:data", Students.class);

		query.setParameter("data", studentsId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Students updateStudent(Students stundent) {

		return manager.merge(stundent);

	}

	@Override
	@Transactional
	public void deleteStudentById(int studentsId) {
		
		Students studnets=manager.find(Students.class, studentsId);
		
		manager.remove(studnets);
	}
}
