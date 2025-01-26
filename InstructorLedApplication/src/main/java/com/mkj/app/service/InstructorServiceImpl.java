package com.mkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.app.entity.ContactDetails;
import com.mkj.app.entity.Instructor;
import com.mkj.app.repository.IInstructorRepository;

import jakarta.transaction.Transactional;

@Service
public class InstructorServiceImpl implements IInstructorService {

	@Autowired
	IInstructorRepository instructorRepository;
	
	
	@Override
	@Transactional
	public Instructor saveInstructor(Instructor instructor) {
		
		System.err.println("1-->>Ins Service "+instructor);
		
		Instructor savedIns = instructorRepository.save(instructor);
		System.err.println("2-->>Ins Service "+savedIns);
		
		return savedIns;
	}

	@Override
	public Instructor getInstructorById(int inscode) {
		if(inscode>0)
		{
			Instructor savedins = instructorRepository.findById(inscode).get();
			return savedins;
		}
		return null;
	}

	@Override
	public List<Instructor> getInstructorsByBaseLocation(String baseLocation) {
		
		return instructorRepository.getInstructorsByBaseLocation(baseLocation);
	}

	@Override
	public List<Instructor> getInstructorsByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Instructor updateContactDetails(int code, ContactDetails cd) {
		
		Instructor ins = getInstructorById(code);
		if(ins!=null)
		{
			ins.setContact(cd);
		}
		return ins;
	}

	
	
	
	
}//end class
