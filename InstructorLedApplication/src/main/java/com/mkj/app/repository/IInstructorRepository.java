package com.mkj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Instructor;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor, Integer>{

	public List<Instructor> getInstructorsByBaseLocation(String baseLocation);
}
