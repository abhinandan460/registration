package com.tmz.registration.service;

import java.util.List;

import com.tmz.registration.exception.RecordsNotFoundException;
import com.tmz.registration.model.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployeeById(Long id) throws RecordsNotFoundException ;
	
	public List<Employee> getAllEmployees() ;
	
	public List<Employee> getEmployeeByName(String empName);
}
