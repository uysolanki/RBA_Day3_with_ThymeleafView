package com.greatlearning.rbawiththymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.rbawiththymeleaf.entity.Department;
import com.greatlearning.rbawiththymeleaf.service.DepartmentService;

@RestController
public class JdbcController {

	@Autowired
	DepartmentService deptservice;
	
	
	@PostMapping("/addDept")
	public Department addDept(@RequestParam("dname") String dname,@RequestParam("hod") String hod)
	{
		Department d=new Department();
		d.setDname("Science");
		d.setHod("Alice");
		return deptservice.addDept(d);
	}
	
	
	@GetMapping("/getDeptByName")
	public Department getDeptByName(@RequestParam("dname") String dname)
	{
		return deptservice.getDeptByName(dname);
	}
}
