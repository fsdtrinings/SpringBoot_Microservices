package com.mkj.app.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingBatch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batchCode;
	private String batchName;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@OneToOne
	@JoinColumn(name = "instructorCode")
	private Instructor instructor;
	
	@OneToMany
	@JoinColumn(name = "batchCode")
	private List<Student> students;
	
	@OneToOne
	@JoinColumn(name = "Course")
	private Course course;
}
