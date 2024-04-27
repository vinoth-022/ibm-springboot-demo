package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		List<Employee> employee = employeeRepository.findAll();

		if (employee.isEmpty()) {
			LOG.warn("No employee found");
			String errorMessage = "Employee not found";
			throw new EmployeeNotFoundException(errorMessage);

		}
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);

		if (empOptional.isEmpty()) {
			String errorMessage = employeeId + " is not found";
			System.out.println(errorMessage);
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		} else
			return empOptional.get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		LOG.info(employee.toString());
		// we have to check if the record is exist already
		// Employee employeeToUpdate = this.getEmployeeById(employee);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(String employeeId, Employee updatedEmployee) {
		LOG.info(employeeId);
		Optional<Employee> employeeToUpdate = employeeRepository.findById(employeeId);
		if (employeeToUpdate != null) {

			Employee existingEmployee = employeeToUpdate.get();

			existingEmployee.setFirstname(updatedEmployee.getFirstname());
			existingEmployee.setSalary(updatedEmployee.getSalary());
			existingEmployee.setLastname(updatedEmployee.getLastname());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setAddress(updatedEmployee.getAddress());

			
			return employeeRepository.save(existingEmployee);

		} else {
			String errorMessage = employeeId + " is not found";
			throw new EmployeeNotFoundException(errorMessage);
		}

	}

	@Override
	public Employee deleteEmployee(String employeeId) {
		LOG.info(employeeId.toString());
		Employee employeeToDelete = this.getEmployeeById(employeeId);
		if (employeeToDelete != null) {
			employeeRepository.deleteById(employeeId);
			return employeeToDelete;
		} else {
			String errorMessage = employeeId + " is not found";
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		LOG.info(firstName);
		List<Employee> empList = employeeRepository.findByFirstname(firstName);
		if (empList.isEmpty()) {
			String errorMessage = firstName + " is not found";
			LOG.warn(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		} else
			return empList;

	}

}

//package com.ibm.springboot.demo.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.ibm.springboot.demo.model.Employee;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	private List<Employee> empList = new ArrayList<>(
//			Arrays.asList(new Employee(101, "Sonu", (double) 90000), new Employee(102, "Monu", (double) 99000),
//					new Employee(103, "Tonu", (double) 2000), new Employee(104, "Gonu", (double) 89000)));
//
//	@Override
//	public Employee getEmployeeById(Integer employeeId) {
//		LOG.info(employeeId.toString());
////		LOG.warn(employeeId.toString());
////		LOG.error(employeeId.toString());
//		return empList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElse(null);
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		LOG.info("getAllEmployees");
//		return empList;
//	}
//
//	@Override
//	public Employee addEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		empList.add(employee);
//		return employee;
//	}
//
//	@Override
//	public Employee updateEmployee(Employee employee) {
//		LOG.info(employee.toString());
//		return empList.set(empList.indexOf(getEmployeeById(employee.getEmployeeId())), employee);
//	}
//
//	@Override
//	public Employee deleteEmployee(Integer employeeId) {
//		LOG.info(employeeId.toString());
//		Employee empToDelete = getEmployeeById(employeeId);
//		empList.remove(empToDelete);
//		return empToDelete;
//	}
//
//}