package com.faisal.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity{
	
	@Column
	private String rolename;
	
	
	
	public Role(){}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	

	public Role(String rolename) {
		super();
		this.rolename = rolename;
		
	}

	@Override
	public String toString() {
		return "Role [" + rolename + "," + "]";
	}

	
	
	
	

}
