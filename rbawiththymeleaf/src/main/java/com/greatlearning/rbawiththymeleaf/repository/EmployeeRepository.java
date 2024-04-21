package com.greatlearning.rbawiththymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.rbawiththymeleaf.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
