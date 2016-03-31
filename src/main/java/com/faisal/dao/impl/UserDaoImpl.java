package com.faisal.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faisal.dao.UserDao;
import com.faisal.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);

	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);

	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUser(userId));

	}

	@Override
	public User getUser(int userId) {
		return (User) session.getCurrentSession().get(User.class, userId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User findUserByName(String username) {
		Criteria criteria = session.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();

	}

}
