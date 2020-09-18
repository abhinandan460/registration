package com.tmz.registration.service;

import java.util.List;

import com.tmz.registration.model.PersonName;

public interface PersonNameService {
	public List<PersonName> getAllPersonNames();
	
	public PersonName addPersonName(PersonName personName);
	
	public void deletePersonNameById(Long id);
}
