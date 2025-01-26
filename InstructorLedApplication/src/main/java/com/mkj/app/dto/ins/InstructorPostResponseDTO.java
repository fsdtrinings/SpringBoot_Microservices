package com.mkj.app.dto.ins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorPostResponseDTO {

	private int insCode;
	private String name;
	private String msg;
}
