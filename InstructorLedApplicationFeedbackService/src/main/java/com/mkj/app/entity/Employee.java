package com.mkj.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empCode;
	private String employeeName;
	private int salary;
	private String gender;
	private String doj;
	private String designation;
	
	@Embedded
	private ContactDetails contact;
	
	public Employee(String employeeName, int salary, String gender, String doj, String designation) {
	
		this.employeeName = employeeName;
		this.salary = salary;
		this.gender = gender;
		this.doj = doj;
		this.designation = designation;
	}

	
}
