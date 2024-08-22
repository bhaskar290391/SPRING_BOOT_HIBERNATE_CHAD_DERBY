package com.practise.jpahibernatecrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practise.jpahibernatecrud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager manager;

	@Autowired
	public StudentDaoImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		manager.persist(student);

	}

	@Override
	public Student findStudentById(int id) {
		return manager.find(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudent() {

		return manager.createQuery(" select s from Student s",Student.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByLastName(String lastName) {
		Query query = manager.createQuery(" select s from Student s where lastName = :lastName",Student.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student merge = manager.merge(student);
		return merge;
	}

	@Override
	@Transactional
	public int updateAllStudent() {
		Query query = manager.createQuery(" update Student set lastName = 'Mudaliyar'");
		return query.executeUpdate();
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		manager.remove(manager.find(Student.class, id));

	}

	@Override
	@Transactional
	public int deleteAllStudent() {
		Query query = manager.createQuery(" delete from Student");
		return query.executeUpdate();
	}

}
