package com.mkj.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mkj.app.entity.Feedback;
import com.mkj.app.entity.Instructor;
import com.mkj.app.service.InstructorServiceImpl;


@RequestMapping("/lap/ins/stu")
@RestController
public class InstructorWebStudentController {

	@Autowired
	InstructorServiceImpl instructorService;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	Logger logger;
	
	public InstructorWebStudentController() {
		logger = LoggerFactory.getLogger(InstructorWebStudentController.class);
	}
	
	@PostMapping("/feedback")
	public Instructor submitFeedback(@RequestParam int icode,@RequestParam int scode ,@RequestBody Feedback feedback) {
		
		
		Instructor instructor = instructorService.getInstructorById(scode);
		if(instructor != null)
		{
			logger.warn("Inside if Instructor is not Null "+instructor);
			// save feedback through feedback service 
			
			String url = "http://FEEDBACKSERVICE/lap/feedback/public?scode="+scode;
			logger.warn("WARN : Inside if Instructor is not Null "+instructor);
			logger.warn("WARN : URL "+url);
			Feedback savedFeedback = restTemplate.postForObject(url, feedback, Feedback.class);
			logger.warn("WARN : Feeddback Service Saved Feedback "+savedFeedback);
			// link feedback with instructor
			Instructor updatedIns = instructorService.saveInstructorFeedback(icode, savedFeedback);
			logger.warn("WARN : Update Instructor's Feedback Size() : "+updatedIns.getFeedbacks().size());
			return updatedIns;
			
		}//end ins != null
		
		return null;
	}
}
