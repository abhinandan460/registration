/**
 * 
 */
package com.tmz.registration.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmz.registration.model.Department;
import com.tmz.registration.service.DepartMentService;

/**
 * @author ayadav
 *
 */
@RestController
public class DepartMentController {

	@Autowired
	DepartMentService departMentService;
	
	@GetMapping(path="/registration/employee/getdepartments")
	public List<Department> getAllDepartments(){
		return departMentService.getAllDepartments();
	}
	
	@PostMapping(path="/registration/employee/addDepartment")
	public Department addDepartment(@RequestBody Department department){
		return departMentService.addDepartment(department);
	}
	@GetMapping(path="/registration/employee/getdepartment/{deptName}")
	public Department getDepartmentByName(@PathVariable String deptName){
		return departMentService.getDepartmentByName(deptName);
	}
}
