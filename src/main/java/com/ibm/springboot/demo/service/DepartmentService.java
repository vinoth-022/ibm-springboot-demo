package com.ibm.springboot.demo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ibm.springboot.demo.model.Department;

public interface DepartmentService {

	public abstract List<Department> getAllDepartments();
	
	public abstract Department getDepartmentById(ObjectId departmentId);

	public abstract Department addDepartment(Department department);
}
