package com.jpahibernate.advancemapping.oneToOneMapping.dao;

import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;

public interface AppDao {

	public void saveInstructor(Instructor data);

	public Instructor findById(int id);

	public void deleteByInstructorId(int id);

	public InstructorDetails findInstructorDetailById(int id);

	public void deleteInstructotDetailById(int id);
}
