package com.mkj.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.Feedback;

@Service
public interface IFeedbackService
{
	
	public Feedback submitFeedback(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
	
	
}
