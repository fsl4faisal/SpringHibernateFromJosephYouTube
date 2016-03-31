package com.faisal.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.dao.UserDao;
import com.faisal.model.Role;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		com.faisal.model.User user = userDao.findUserByName(username);
		System.out.println("Inside UserDetails loadUserByUsername");
		if (user != null) {
			String password = user.getPassword();
			boolean enabled = user.getStatus().equals("ACTIVE");

			boolean accountNonExpired = user.getStatus().equals("ACTIVE");
			boolean credentialNonExpired = user.getStatus().equals("ACTIVE");
			boolean accountNonLocket = user.getStatus().equals("ACTIVE");

			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getRolename()));
				System.out.println("User Roles are:"+role);
			}

			User securityUser = new User(username, password, enabled,
					accountNonExpired, credentialNonExpired, accountNonLocket,
					authorities);
			return securityUser;
		}

		else {
			throw new UsernameNotFoundException("User not found..!!");
		}

	}

}
