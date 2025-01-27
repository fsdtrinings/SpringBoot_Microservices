package com.mkj.app.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.mkj.app.entity.Student;
import com.mkj.app.service.IFeedbackService;

@RestController
@RequestMapping("/lap/feedback/public")
public class FeedbackPublicController {

	@Autowired
	IFeedbackService feedbackService;
	
	@Autowired
	RestTemplate restTemplate;
	

	Logger logger;
	
	public FeedbackPublicController() {
		System.out.println("Contructor called Feedback Public Controller");
		logger = LoggerFactory.getLogger(FeedbackPublicController.class);
	}
	
	@PostMapping("")
	public Feedback setFeedbackForInstructor(@RequestBody Feedback rawfeedback,@RequestParam int scode)
	{
		// String url = url to get Student from Student Service based on scode
		// Student s = restTemplate.getForEntity(null, null) ; // Statement not in use as Student service is pending 
	
		String stuName [] = {
			"Nandu","Bhola","Mohan","Ramesh","Suresh","Mahesh","Lokesh","Brijesh","Rakesh","Kavita","Babita","Savita","Sartia","Neha","Pooja","Versha","Alok","Amit","Pradeep"	
		};
		String studentName = stuName[new Random().nextInt(stuName.length)];
		String designation = "Trainee";
		
		rawfeedback.setReviewerName(studentName);
		rawfeedback.setDesignation(designation);
		logger.warn("WARN : Raw feedback "+rawfeedback);
		Feedback savedFeedback = feedbackService.submitFeedback(rawfeedback);
		logger.warn("WARN : Feedback Saved "+savedFeedback);
		 
		return savedFeedback;
	}
	
	
}
