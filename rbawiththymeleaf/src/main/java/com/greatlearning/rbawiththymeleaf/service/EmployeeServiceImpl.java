package com.greatlearning.rbawiththymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.rbawiththymeleaf.entity.Employee;
import com.greatlearning.rbawiththymeleaf.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
	}

}
