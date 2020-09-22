package com.tmz.registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmz.registration.model.Department;
import com.tmz.registration.model.Employee;
import com.tmz.registration.model.Person;
import com.tmz.registration.model.PersonName;
import com.tmz.registration.repository.user.DepartMentRepository;
import com.tmz.registration.repository.user.EmployeeRepository;
import com.tmz.registration.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	DepartMentRepository departMentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employee.getDepartMent()!=null) {
			Department department=departMentRepository.findByName(employee.getDepartMent().getName());
			Person person=employee.getPerson();
			List<PersonName> names=person.getNames();
			names.forEach((name)->{
				name.setPerson(person);
			});
			
			if(department ==null) {
				department=new Department();
				department.setName(employee.getDepartMent().getName());
				//department.setId(employee.getDepartMent().getId());
			}				
			employee.setDepartMent(department);
			employee.setPerson(person);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(id).orElse(null);
		if(employee!=null)
			employeeRepository.delete(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByName(empName);
	}

}
