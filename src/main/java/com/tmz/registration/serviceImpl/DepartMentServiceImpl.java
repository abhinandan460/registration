package com.tmz.registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmz.registration.model.Department;
import com.tmz.registration.repository.user.DepartMentRepository;
import com.tmz.registration.service.DepartMentService;

@Service
public class DepartMentServiceImpl implements DepartMentService {
	
	@Autowired
	DepartMentRepository departMentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departMentRepository.findAll();
	}

	@Override
	public Department addDepartment(Department deaprtment) {
		// TODO Auto-generated method stub
		return departMentRepository.save(deaprtment);
	}

	@Override
	public Department getDepartmentByName(String deptName) {
		// TODO Auto-generated method stub
		return departMentRepository.findByName(deptName);
	}

	
}
