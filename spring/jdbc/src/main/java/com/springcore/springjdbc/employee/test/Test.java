package com.springcore.springjdbc.employee.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.springjdbc.employee.dao.EmployeeDao;
import com.springcore.springjdbc.employee.dto.Employee;

import java.util.List;

import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDaoImpl");
		Employee emp = new Employee();
		emp.setId(45);
		emp.setName("Bob");
		emp.setLastName("Kosinskiy");
//		int result = dao.create(emp);
//		int result = dao.update(emp);
//		int result = dao.delete(45);
//		Employee emp2 = dao.read(41);
		List<Employee> result = dao.read();
		System.out.println("Our employee : " + result);
	}
}
