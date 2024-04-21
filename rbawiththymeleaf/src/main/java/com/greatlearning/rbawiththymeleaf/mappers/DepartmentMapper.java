package com.greatlearning.rbawiththymeleaf.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.greatlearning.rbawiththymeleaf.entity.Department;

public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department d1=new Department();
		d1.setDno(rs.getInt(1));
		d1.setDname(rs.getString(2));
		d1.setHod(rs.getString(3));
		return d1;
	}

}
