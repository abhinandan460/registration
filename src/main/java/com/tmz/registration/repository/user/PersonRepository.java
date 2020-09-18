package com.tmz.registration.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmz.registration.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
