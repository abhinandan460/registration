package com.tmz.registration.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmz.registration.model.Department;

@Repository
public interface DepartMentRepository extends JpaRepository<Department, Long> {
	
	@Query("SELECT d FROM Department d WHERE d.name =:deptName")
	public Department findByName(@Param("deptName") String deptName);

}
