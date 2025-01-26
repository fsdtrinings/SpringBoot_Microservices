package com.mkj.app.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends Employee{

	private String task; // training , Sprint , Interview 
	private int marks;
	private boolean activeStatus; 
	private String baseLocation;
	private String currentLocation;
	
	@OneToMany
	private List<Feedback> feedbacks;
	
}
