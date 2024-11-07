package org.acumen.training.codes.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // <bean />
public class Employee {
	private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());
	//@Value("101")
	private Integer empId;
	//@Value("Kanye West")
	private String fullname;
	//@Value("50")
	private Integer age;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public Employee(@Value("102") Integer empId, @Value("Kendrick Lamar")String fullname, @Value("23")Integer age ) {
	//public EmployeePojo(Integer empId, String fullname, Integer age ) {
		this.empId = empId;
		this.fullname= fullname;
		this.age = age;

	
	}
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void createBean() {
		LOGGER.info("Create EmployeePojo Object");
	}
	
	public void destroyBean() {
		LOGGER.info("Destroying EmployeePojo Object");
		
	}
	@Override
	public String toString() {
		return "EmployeePojo [empId=" + empId + ", fullname=" + fullname  + ", age=" + age
				+ "]";
	}
	
}
