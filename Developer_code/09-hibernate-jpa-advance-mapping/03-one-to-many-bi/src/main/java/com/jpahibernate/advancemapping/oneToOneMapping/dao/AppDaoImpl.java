package com.jpahibernate.advancemapping.oneToOneMapping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpahibernate.advancemapping.oneToOneMapping.entity.Courses;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;

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
	@Transactional
	public void deleteByInstructorId(int id) {
		Instructor instructor = manager.find(Instructor.class, id);

		manager.remove(instructor);

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
		TypedQuery<Instructor> query = manager.createQuery("select i from Instructor i "
				+ " join fetch i.courses "
				+ " join fetch i.details where i.id=:data", Instructor.class);
		
		query.setParameter("data", id);
		return query.getSingleResult();
	}

}
