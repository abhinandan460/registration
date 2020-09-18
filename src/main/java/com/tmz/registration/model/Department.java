package com.tmz.registration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department extends BaseClass implements Serializable {
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
		super.setUuid(UUID.randomUUID().toString());
		super.setCreatedDate(new Date());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="dept_name")
	private String name;

	@Id
	@Column(name = "dept_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", getId()=" + getId() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getCreatedBy()=" + getCreatedBy() + ", isVoided()=" + isVoided() + ", getVoidedBy()="
				+ getVoidedBy() + ", getChangeDate()=" + getChangeDate() + ", getChangedBy()=" + getChangedBy()
				+ ", getUuid()=" + getUuid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
