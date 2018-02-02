package com.accenture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.dao.AccountDao;
import com.accenture.domain.User;
import com.accenture.exception.AuthenticationException;

@Service
public class AccountService {

	@Autowired
	AccountDao accountdao;

	public User login(String username, String password) throws AuthenticationException {
		User user = this.accountdao.findByUsername(username);

		if (user != null) {

			if (!user.getPassword().equalsIgnoreCase(password)) {
				throw new AuthenticationException("Wrong username/password combination.", "invalid.password");
			}
		} else {
			throw new AuthenticationException("Wrong username/password combination.", "invalid.username");
		}
		return null;
	}

	public void save(User account) {
		// TODO Auto-generated method stub
		
	}

}
