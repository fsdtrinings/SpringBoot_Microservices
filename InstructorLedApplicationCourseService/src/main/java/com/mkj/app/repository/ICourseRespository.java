package com.mkj.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkj.app.entity.Course;

@Repository
public interface ICourseRespository extends JpaRepository<Course,Integer>{

	public Course getCourseByCourseName(String courseName);
}
