package com.greatlearning.rbawiththymeleaf.service;

import java.util.List;

import com.greatlearning.rbawiththymeleaf.entity.Employee;

public interface EmployeeService {
	
		List<Employee> getAllEmployees();
		
		Employee saveEmployee(Employee employee);
		
		Employee getEmployeeById(int id);
		
		Employee updateEmployee(Employee employee);
		
		void deleteEmployeeById(int id);
}
