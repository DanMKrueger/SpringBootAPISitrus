package com.sitrus.user.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitrus.repository.UserRepository;
import com.sitrus.user.model.User;

@Service("userServiceInterface")
public abstract class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRep;

	@Override
	public Optional<User> findUserByEmail(String email) {

		return userRep.findByEmail(email);

	}

	@Override
	public void save(User user) {
		userRep.save(user);
	}

}
