package com.training.utils;

import java.util.List;

import com.training.entity.Courses;
import com.training.entity.Student;

public interface CourseDAO {
	public int addCourse(Courses course);
	//public int removeCourse(long courseId);
	public List<Student> getStudents(String courseName);
	
	//public List<Courses> getAllCourses();
}
