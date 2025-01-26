package com.mkj.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mkj.app.dto.course.CoursePOSTResponseDTO;
import com.mkj.app.entity.Course;
import com.mkj.app.entity.Instructor;
import com.mkj.app.service.ICourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/lap/manager")
public class CourseSMEWebController {

	@Autowired
	ICourseService courseService;
	
	@Autowired
	RestTemplate restTemplate;
	
	// creating a logger
    Logger logger;
       
	
	public CourseSMEWebController() {
		System.out.println("Constructor called");
		logger = LoggerFactory.getLogger(CourseSMEWebController.class);
	}

	@PostMapping("/course")
	public Course createNewCourse(@RequestBody CoursePOSTResponseDTO coursedto)
	{
		
		Course inputCourse = new Course();
		inputCourse.setCourseName(coursedto.getCourseName());
		inputCourse.setDescription(coursedto.getDescription());
		inputCourse.setDurationInDays(coursedto.getDurationInDays());
		
		Course savedCourse = courseService.createNewCourse(inputCourse);
		return savedCourse;
	}
	
	@PutMapping("/link")
	public ResponseEntity<Course> addTrainer(@RequestParam(required = true) int cc,@RequestParam(required = true) int ic)
	{
		// call instructor service 
		// call getInstructorByCode()
		// bind trainer here
		logger.warn("\n1---> cc "+cc+"ic "+ic);
		String url = "http://INSTRUCTORSERVICE/lap/hr/instructor/"+ic;
		logger.warn("2 URL -->> "+url);
		Instructor instructor = restTemplate.getForObject(url, Instructor.class);
		logger.warn("3 Instructor -->> "+instructor+" "+instructor.getEmpCode()+" "+instructor.getEmployeeName());
		
		Course course = courseService.linkInstructor(cc, instructor);
		logger.warn("6 --->> Course "+course);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
}








