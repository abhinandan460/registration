package com.tmz.registration.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tmz.registration.exception.RecordsNotFoundException;
import com.tmz.registration.model.Employee;
import com.tmz.registration.response.ResponseEntity;
import com.tmz.registration.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(path="registration/employee/addEmployee")
	public ResponseEntity addEmployee(@RequestBody Employee employee) {
		ResponseEntity responseEntity=new ResponseEntity();
		Employee emp=employeeService.addEmployee(employee);
		if(emp!=null) {
			responseEntity.setStatusCode(201);
			responseEntity.setStatusMessage("Records Saved Sucessfully");
		}else {
			responseEntity.setStatusCode(404);
			responseEntity.setStatusMessage("Records Not Sucessfully saved");
		}
		return responseEntity;
	}
	
	@DeleteMapping(path="registration/employee/deleteEmployee/{empId}")
	public ResponseEntity deleteEmployeeById(@PathVariable Long empId) {
		ResponseEntity responseEntity=new ResponseEntity();
		try {
			employeeService.deleteEmployeeById(empId);
			responseEntity.setStatusCode(201);
			responseEntity.setStatusMessage("Record deleted");
			
		}catch(Exception e) {
			throw new RecordsNotFoundException("Records not Found {"+empId+"}");
		}
		return responseEntity;
	}
	@GetMapping(path="registration/employee/employees")
	public Object getAllEmployees(){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonValue="";
		try {
			jsonValue=mapper.writeValueAsString(employeeService.getAllEmployees());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonValue;
	}
	@GetMapping(path="registration/employee/employees/{empName}")
	public Object getEmployeesByName(@PathVariable String empName){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonValue="";
		try {
			jsonValue=mapper.writeValueAsString(employeeService.getEmployeeByName(empName));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonValue;
	}
}
