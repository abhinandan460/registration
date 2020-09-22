package com.tmz.registration.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmz.registration.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e, pn FROM Employee as e inner join Person as p on e.person=p.id"
			+"\ninner join PersonName as pn on p.id = pn.person where pn.firstName like %:empName%")
	public List<Employee> getEmployeeByName(@Param("empName") String empName);
}
