package com.priyansu.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

	@SuppressWarnings("unused")
	private Long id;
	
	@SuppressWarnings("unused")
	private String name;

	@SuppressWarnings("unused")
	private String email;
	
	@SuppressWarnings("unused")
	private String bloodgroup;
}
