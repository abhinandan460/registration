/**
 * 
 */
package com.tmz.registration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author ayadav
 *
 */
@Entity
@Table(name="person")
public class Person extends BaseClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="gender")
	private String gender;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="person", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<PersonName> names;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
		super.setUuid(UUID.randomUUID().toString());
		super.setCreatedDate(new Date());
	}

	public List<PersonName> getNames() {
		return names;
	}

	public void setNames(List<PersonName> names) {
		this.names = names;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
