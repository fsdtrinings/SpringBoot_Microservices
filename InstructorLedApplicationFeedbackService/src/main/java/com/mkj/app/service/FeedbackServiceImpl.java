package com.mkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.app.entity.Feedback;
import com.mkj.app.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackRepository feedbackRepository;
	
	@Override
	public Feedback submitFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

}
