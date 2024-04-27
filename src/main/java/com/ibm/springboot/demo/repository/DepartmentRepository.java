package com.ibm.springboot.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.springboot.demo.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, ObjectId>{
	
	// code here 

}
