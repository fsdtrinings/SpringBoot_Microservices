package com.mkj.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.dto.ins.InstructorPostRequestDTO;
import com.mkj.app.dto.ins.InstructorPostResponseDTO;
import com.mkj.app.entity.Employee;
import com.mkj.app.entity.Feedback;
import com.mkj.app.entity.Instructor;
import com.mkj.app.service.IInstructorService;

@RestController
@RequestMapping("lap/hr")
public class InstructorWebHRController {

	
	@Autowired
	IInstructorService insService;
	
	
	public InstructorWebHRController() {
		System.out.println("Instructor Web Service Initiated ");
	}
	
	@PostMapping("/save/instructor")
	public ResponseEntity<InstructorPostResponseDTO> saveinsHandler(@RequestBody InstructorPostRequestDTO dto)
	{

			
		
		Instructor rawInst = new Instructor( dto.getName(),dto.getSalary(),dto.getGender(),dto.getDoj(),
											 dto.getDesignation(),dto.getBaseLocation());
		System.err.println("Inside Controller raw ins "+rawInst);
		Instructor savedInstructor = insService.saveInstructor(rawInst);
		
		InstructorPostResponseDTO dto2 = new InstructorPostResponseDTO(savedInstructor.getEmpCode(), savedInstructor.getEmployeeName(), "Employee Saved , Designation "+savedInstructor.getDesignation());
		return new ResponseEntity<InstructorPostResponseDTO>(dto2, HttpStatus.CREATED);
	}
	@GetMapping("/instructor/{insCode}")
	public ResponseEntity<Instructor> getInstructorByCode(@PathVariable int insCode)
	{
		
		 Instructor savedInstructor = insService.getInstructorById(insCode);
		return new ResponseEntity<Instructor>(savedInstructor, HttpStatus.FOUND);
	}
	
	@GetMapping("/instructor/location/{location}")
	public ResponseEntity<List<Instructor>> getInstructorbasedonlocation(@PathVariable String location)
	{
		
		 List<Instructor> allInstructors = insService.getInstructorsByBaseLocation(location);
		return new ResponseEntity<List<Instructor>>(allInstructors, HttpStatus.FOUND);
	}
	
	
	
}
