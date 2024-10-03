package com.jpahibernate.advancemapping.oneToOneMapping.dao;

import java.util.List;

import com.jpahibernate.advancemapping.oneToOneMapping.entity.Courses;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Instructor;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.InstructorDetails;
import com.jpahibernate.advancemapping.oneToOneMapping.entity.Students;

public interface AppDao {

	public void saveInstructor(Instructor data);

	public Instructor findById(int id);

	public InstructorDetails findInstructorDetailById(int id);

	public void deleteInstructotDetailById(int id);

	public List<Courses> findCourseByInstructorId(int id);

	public Instructor findInstructorByJoinFetch(int id);

	public Instructor updateInstructor(int id);

	public Courses updateCourses(int id);

	public void deleteByInstructorId(int id);

	public void deleteCoursesById(int id);

	public void saveCourse(Courses theCouse);

	public Courses retrieveCourseAndReviewByJoinFetch(int id);

	public Courses fetchCourseAndStudentByCourseId(int courseId);

	public Students fetchStudentAndCourseByStudentId(int studentsId);

	public Students updateStudent(Students stundent);

	public void deleteStudentById(int studentsId);
}
