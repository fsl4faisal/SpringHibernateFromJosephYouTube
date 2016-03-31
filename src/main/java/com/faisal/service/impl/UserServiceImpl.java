package com.faisal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.dao.UserDao;
import com.faisal.model.User;
import com.faisal.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	

	@Transactional
	public void add(User user) {
		userDao.add(user);
		
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
		
	}

	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Transactional
	public User findUserByName(String username) {
		return userDao.findUserByName(username);
	}

}
