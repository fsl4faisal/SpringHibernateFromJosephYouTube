package com.faisal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.dao.RoleDao;
import com.faisal.model.Role;
import com.faisal.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	

	@Transactional
	public void add(Role role) {
		roleDao.add(role);
		
	}

	@Transactional
	public void edit(Role role) {
		roleDao.edit(role);
		
	}

	@Transactional
	public void delete(int roleId) {
		roleDao.delete(roleId);
		
	}

	@Transactional
	public Role getRole(int roleId) {
		return roleDao.getRole(roleId);
	}

	@Transactional
	public List<Role> getAllRole() {
		return roleDao.getAllRole();
	}

}
