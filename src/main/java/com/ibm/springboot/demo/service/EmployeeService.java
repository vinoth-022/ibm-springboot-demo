package com.ibm.springboot.demo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ibm.springboot.demo.model.Employee;

public interface EmployeeService {

	public abstract List<Employee> getAllEmployees();

	public abstract Employee getEmployeeById(String employeeId);

	public abstract Employee addEmployee(Employee employee);

	public abstract Employee updateEmployee(String employeeId, Employee updatedEmployee);

	public abstract Employee deleteEmployee(String employeeId);

	public abstract List<Employee> getEmployeeByFirstName(String firstName);

}