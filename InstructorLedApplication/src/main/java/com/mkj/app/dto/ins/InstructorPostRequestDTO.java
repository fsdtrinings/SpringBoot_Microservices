package com.mkj.app.dto.ins;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorPostRequestDTO {

	private String name;
	private int salary;
	private String doj;
	private String designation;
	private String gender;
	private String baseLocation;
}
