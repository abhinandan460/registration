/**
 * 
 */
package com.tmz.registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmz.registration.model.PersonName;
import com.tmz.registration.repository.user.PersonNameRepository;
import com.tmz.registration.service.PersonNameService;

/**
 * @author ayadav
 *
 */
@Service
public class PersonNameServiceImpl implements PersonNameService {
	
	@Autowired
	PersonNameRepository personNameRepository;
	@Override
	public List<PersonName> getAllPersonNames() {
		// TODO Auto-generated method stub
		return personNameRepository.findAll();
	}
	@Override
	public PersonName addPersonName(PersonName personName) {
		// TODO Auto-generated method stub
		personName.setPerson(personName.getPerson());
		return personNameRepository.save(personName);
	}
	@Override
	public void deletePersonNameById(Long id) {
		// TODO Auto-generated method stub
		PersonName personName=personNameRepository.findById(id).orElse(null);
		personNameRepository.delete(personName);
	}

}
