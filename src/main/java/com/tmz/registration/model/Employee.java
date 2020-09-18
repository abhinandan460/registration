package com.tmz.registration.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee_detalis")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee extends BaseClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.ALL,CascadeType.MERGE, CascadeType.DETACH},fetch = FetchType.LAZY,targetEntity = Department.class)
	@JoinColumn(name="dept_id", nullable = true)
	
	private Department departMent;
	
	@JoinColumn(name="person_id",nullable=false)
	@OneToOne(targetEntity = Person.class,fetch = FetchType.LAZY, cascade = {CascadeType.ALL,CascadeType.MERGE})
	private Person person;

	public Department getDepartMent() {
		return departMent;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
		super.setUuid(UUID.randomUUID().toString());
		super.setCreatedDate(new Date());
	}

	public void setDepartMent(Department departMent) {
		this.departMent = departMent;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departMent == null) ? 0 : departMent.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (departMent == null) {
			if (other.departMent != null)
				return false;
		} else if (!departMent.equals(other.departMent))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [departMent=" + departMent + ", person=" + person + ", getId()=" + getId()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getCreatedBy()=" + getCreatedBy() + ", isVoided()="
				+ isVoided() + ", getVoidedBy()=" + getVoidedBy() + ", getChangeDate()=" + getChangeDate()
				+ ", getChangedBy()=" + getChangedBy() + ", getUuid()=" + getUuid() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
