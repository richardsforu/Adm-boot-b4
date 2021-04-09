package com.cts.employee.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId implements Serializable{
	
	
	private int employeeId;
	private int deptId;
	
	
	public EmployeeId() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeId(int employeeId, int deptId) {
		this.employeeId = employeeId;
		this.deptId = deptId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	
	
	
	
	

}
