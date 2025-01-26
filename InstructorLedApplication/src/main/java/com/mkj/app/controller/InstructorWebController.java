package com.mkj.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.ContactDetails;
import com.mkj.app.entity.Instructor;
import com.mkj.app.service.IInstructorService;

@RestController
@RequestMapping("lap/ins")
public class InstructorWebController {

	@Autowired
	IInstructorService insService;
	
	public InstructorWebController() {
		System.out.println("Instructor Web Controller Initiate");
	}

	@PutMapping("/modify/contactdetails")
	public ResponseEntity<Instructor> updateContactInfo(@RequestParam(required = true)int code
			,@RequestBody ContactDetails cd)
	{
		System.err.println("Modify Contact Details "+code+" CD "+cd);
		
		Instructor savedins = insService.updateContactDetails(code, cd);
		return new ResponseEntity<Instructor>(savedins, HttpStatus.CREATED);
	}
}//end class
