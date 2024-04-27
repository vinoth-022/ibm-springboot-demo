package com.ibm.springboot.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employee")
public class Employee {

	@Id
	private String employeeId;
	private String firstname;
	private Double salary;

	private String lastname;
	private String email;
	private String address;

//	constructors, getters, setters etc 

	public Employee() {
		super();
	}

	public Employee(String employeeId, String firstname, Double salary, String lastname, String email, String address) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.salary = salary;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", salary=" + salary + ", lastname="
				+ lastname + ", email=" + email + ", address=" + address + "]";
	}
	

	


}