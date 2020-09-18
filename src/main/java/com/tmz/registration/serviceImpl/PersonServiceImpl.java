package com.tmz.registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmz.registration.model.Person;
import com.tmz.registration.repository.user.PersonRepository;
import com.tmz.registration.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

}
