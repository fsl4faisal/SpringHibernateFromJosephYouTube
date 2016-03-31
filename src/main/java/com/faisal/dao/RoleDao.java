package com.faisal.dao;

import java.util.List;

import com.faisal.model.Role;

public interface RoleDao {
	
		public void add(Role role);
		public void edit(Role role);
		public void delete(int roleId);
		public Role getRole(int roleId);
		public List<Role> getAllRole();

}
