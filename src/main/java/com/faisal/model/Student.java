package com.faisal.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity {

	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private int yearLevel;

	public Student() {
	}

	public Student(String firstname, String lastname, int yearLevel) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;
		this.yearLevel = yearLevel;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

}
