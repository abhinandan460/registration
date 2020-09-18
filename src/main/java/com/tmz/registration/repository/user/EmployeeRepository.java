package com.tmz.registration.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmz.registration.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
