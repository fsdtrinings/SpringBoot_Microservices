package com.mkj.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lap/public")
public class CoursePublicWebController {

	public CoursePublicWebController() {
		System.out.println("Contructor called ");
	}
	
	
}
