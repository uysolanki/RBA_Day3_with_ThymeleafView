package com.greatlearning.rbawiththymeleaf.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.greatlearning.rbawiththymeleaf.entity.Department;
import com.greatlearning.rbawiththymeleaf.mappers.DepartmentMapper;

@Component
public class DepartmentRepoClass {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Department findDepartmentByName(String dname)
	{
		String query="select *  from department d where d.dname=?";
		return this.jdbcTemplate.queryForObject(query, new DepartmentMapper(),dname);
	}

}
