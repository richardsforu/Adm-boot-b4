package com.cts.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.employee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	

}
