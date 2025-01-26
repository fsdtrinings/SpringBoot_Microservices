package com.mkj.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.app.controller.CourseSMEWebController;
import com.mkj.app.entity.Course;
import com.mkj.app.entity.Instructor;
import com.mkj.app.repository.ICourseRespository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	ICourseRespository courseRepository;
	
	Logger logger;
	

	
	@Override
	@Transactional
	public Course createNewCourse(Course course)
	{
		Course savedCourse = courseRepository.save(course);
		return savedCourse;
	}
	
	@Override
	@Transactional
	public Course linkInstructor(int courseCode,Instructor instructor) {
		logger = LoggerFactory.getLogger(CourseSMEWebController.class);
		
		
		List<Instructor> instructorsToUpdate = null;
		
		Course course = getCourseById(courseCode);
		logger.warn("--->> 4 all Course "+course);
		if(course != null && instructor !=null)
		{
			List<Instructor> insFromDBList = course.getTrainers();
			
			
		
			
			logger.warn("--->> 5 all Instructor "+insFromDBList);
			if(insFromDBList!= null && !insFromDBList.isEmpty())
			{
				logger.warn("--->> 6 Inside if -Instructor");
				insFromDBList.add(instructor);
				instructorsToUpdate = insFromDBList;
				
				
			}
			else {
				logger.warn("--->> 6 Inside else - Instructor");
				ArrayList<Instructor> list = new ArrayList<>();
				list.add(instructor);
				
				instructorsToUpdate = list;
			}
			
			
			
			
		}
		
		course.setTrainers(instructorsToUpdate);
	
		
		return course;
	}
	
	

	@Override
	public Course getCourseById(int code) {
		
		return courseRepository.findById(code).get();
	}

	@Override
	public Course getCourseByCourseName(String courseName) {
		
		return courseRepository.getCourseByCourseName(courseName);
	}
	
	
}
