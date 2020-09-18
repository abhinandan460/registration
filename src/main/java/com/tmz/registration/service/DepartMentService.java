package com.tmz.registration.service;

import java.util.List;

import com.tmz.registration.model.Department;

public interface DepartMentService {
	public List<Department> getAllDepartments();
	
	public Department addDepartment(Department department);
	
	public Department getDepartmentByName(String deptName);

}
