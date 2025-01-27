package com.mkj.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> 
{

}
