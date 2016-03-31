package com.faisal.dao;

import java.util.List;

import com.faisal.model.User;

public interface UserDao {
	
		public void add(User user);
		public void edit(User user);
		public void delete(int userId);
		public User getUser(int userId);
		public List<User> getAllUser();
		public User findUserByName(String username);

}
