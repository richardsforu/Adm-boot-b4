package com.cts.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.employee.dao.EmployeeDao;
import com.cts.employee.entity.Employee;
import com.cts.employee.entity.EmployeeId;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		
		EmployeeDao empDao = ac.getBean(EmployeeDao.class);
		
		EmployeeId id1=new EmployeeId(100, 10);
		EmployeeId id2=new EmployeeId(101, 20);
		EmployeeId id3=new EmployeeId(102, 30);
		EmployeeId id4=new EmployeeId(103, 10);
		
		
		Employee e1=new Employee("Praveen", 15000, "abc@abc.com", id1);
		Employee e2=new Employee("James", 35000, "james@abc.com", id2);
		Employee e3=new Employee("Bucky", 45000, "bucky@abc.com", id3);
		Employee e4=new Employee("Rose", 55000, "rose@abc.com", id4);

		e1.setInfo("This Employee is Good");
		e2.setInfo("This Employee is Bad");
		e3.setInfo("This Employee is Inactive");
		e4.setInfo("This Employee is always sleeps");
		
		//empDao.save(e1); // save act like saveOrUpdate
		//empDao.save(e2);
		//empDao.save(e3);
		//empDao.save(e4);
		
		//empDao.findById(null)
		
		
		
		
		
		
		

		
	}

}
