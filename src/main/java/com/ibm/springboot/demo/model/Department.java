package com.ibm.springboot.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
public class Department {

	@Id
	private ObjectId departmentId;
	private String departmentName;
	private String location;
	private String managerId;
	
	public Department() {
		super();
	}

	public Department(ObjectId departmentId, String departmentName, String location, String managerId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
		this.managerId = managerId;
	}

	public ObjectId getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(ObjectId departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location="
				+ location + ", managerId=" + managerId + "]";
	}
	
	
	
	

	
}