package com.jpahibernate.advancemapping.oneToOneMapping.dao;

import java.util.List;

import com.jpahibernate.advancemapping.oneToOneMapping.entity.Courses;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;

public interface AppDao {

	public void saveInstructor(Instructor data);

	public Instructor findById(int id);

	public void deleteByInstructorId(int id);

	public InstructorDetails findInstructorDetailById(int id);

	public void deleteInstructotDetailById(int id);

	public List<Courses> findCourseByInstructorId(int id);

	public Instructor findInstructorByJoinFetch(int id);
}
