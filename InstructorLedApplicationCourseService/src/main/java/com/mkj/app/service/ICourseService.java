package com.mkj.app.service;

import com.mkj.app.entity.Course;
import com.mkj.app.entity.Instructor;

public interface ICourseService {

	public Course createNewCourse(Course course);
	public Course getCourseById(int code);
	public Course getCourseByCourseName(String courseName);
	
	public Course linkInstructor(int courseCode,Instructor instructor);
	
	
}
