package com.greatlearning.rbawiththymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.rbawiththymeleaf.entity.Department;
import com.greatlearning.rbawiththymeleaf.repository.DepartmentRepoClass;
import com.greatlearning.rbawiththymeleaf.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository deptrepo;
	
	@Autowired
	DepartmentRepoClass deptrepoclass;

	public Department addDept(Department d) {
		return deptrepo.save(d);
	}

	public Department getDeptByName(String dname) 
	{
		return deptrepoclass.findDepartmentByName(dname);
	}



}
