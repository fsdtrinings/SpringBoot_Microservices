package com.mkj.app.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePOSTResponseDTO {
	private String courseName;
	private String description;
	private int durationInDays;
}
