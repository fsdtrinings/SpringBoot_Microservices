package com.mkj.app.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Instructor extends Employee {
	
	
	private String baseLocation;
	
	@OneToMany
	@JoinColumn(name="linkedWith")
	private List<Feedback> feedbacks;
	
	
	
	// ------------------------------------------------------------
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	
	public Instructor(String employeeName,
			int salary,String gender,
			String doj,String designation,
			String baseLocation)
	{
		super(employeeName,salary,gender,doj,designation);
		this.baseLocation = baseLocation;
	}
	
	
	
	

}

