package com.ibm.springboot.demo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@Override
	public List<Department> getAllDepartments() {
		LOG.info("getAllEmployees");
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(ObjectId objectId) {
		LOG.info(objectId.toString());
		return departmentRepository.findById(objectId).get();
	}

	@Override
	public Department addDepartment(Department department) {
		LOG.info(department.toString());
		return departmentRepository.save(department);
	}

}
