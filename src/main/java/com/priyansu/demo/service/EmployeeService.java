package com.priyansu.demo.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyansu.demo.dto.response.EmployeeResponse;
import com.priyansu.demo.entity.Employee;
import com.priyansu.demo.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceInterf{

	private final ModelMapper modelMapper;

	private final EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeResponse getEmployeeDetailsById(Long id) {
		try {
			Optional<Employee> employee = employeeRepository.findById(id);
			
			if (employee.isPresent()) {
                return modelMapper.map(employee, EmployeeResponse.class);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
//			e.printStackTrace();
		}
	}

}
