package com.mkj.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.ContactDetails;
import com.mkj.app.entity.Feedback;
import com.mkj.app.entity.Instructor;

@Service
public interface IInstructorService {

	public Instructor saveInstructor(Instructor instructor);
	public Instructor getInstructorById(int inscode);
	public List<Instructor> getInstructorsByBaseLocation(String baseLocation); 
	
	public Instructor updateContactDetails(int code,ContactDetails cd);
	
	// pending
	public List<Instructor> getInstructorsByCourseName(String courseName);
	
	public Instructor saveInstructorFeedback(int icode , Feedback feedback);
	
	
	
}
