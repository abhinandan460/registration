/**
 * 
 */
package com.tmz.registration.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmz.registration.exception.RecordsNotFoundException;
import com.tmz.registration.model.PersonName;
import com.tmz.registration.response.ResponseEntity;
import com.tmz.registration.service.PersonNameService;

/**
 * @author ayadav
 *
 */
@RestController
public class PersonNameController {
	@Autowired
	PersonNameService personNameService;
	
	@GetMapping(path="registration/employee/personNames")
	public List<PersonName> getAllPersonNames(){	
		return personNameService.getAllPersonNames();
	}
	@PostMapping(path="registration/employee/addPerson")
	public PersonName addPersoName(@RequestBody PersonName personName){
		
		return personNameService.addPersonName(personName);
	}
	@DeleteMapping(path="registration/employee/deletePersonName/{nameId}")
	public ResponseEntity deletePersonNameById(@PathVariable Long nameId) {
		ResponseEntity responseEntity=new ResponseEntity();
		try {
			personNameService.deletePersonNameById(nameId);;
			responseEntity.setStatusCode(201);
			responseEntity.setStatusMessage("Records deleted");
			
		}catch(Exception e) {
			throw new RecordsNotFoundException("Records not Found {"+nameId+"}");
		}
		return responseEntity;
	}
	
}
