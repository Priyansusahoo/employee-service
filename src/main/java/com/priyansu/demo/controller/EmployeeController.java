package com.priyansu.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyansu.demo.dto.response.EmployeeResponse;
import com.priyansu.demo.service.EmployeeServiceInterf;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController{
	
	@Autowired
	private final EmployeeServiceInterf employeeServiceInterf;

    @GetMapping("/getEmployeeDetails/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable Long id) {
		EmployeeResponse employeeResponse = employeeServiceInterf.getEmployeeDetailsById(id);
		
		if(employeeResponse.equals(null)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmployeeResponse());
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		}
	}
}