package com.cts.employee.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Employee{
	
	@Transient
	private String info;
	private String employeeName;
	private double salary;
	private String emailAddress;

	@EmbeddedId
	private EmployeeId employeeId;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeName, double salary, String emailAddress, EmployeeId employeeId) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.emailAddress = emailAddress;
		this.employeeId = employeeId;
	}
	
	

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

}
