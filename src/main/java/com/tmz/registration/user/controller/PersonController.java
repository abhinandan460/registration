/**
 * 
 */
package com.tmz.registration.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmz.registration.model.Person;
import com.tmz.registration.service.PersonService;

/**
 * @author ayadav
 *
 */
@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(path="registration/employee/getAllPersons")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
}
