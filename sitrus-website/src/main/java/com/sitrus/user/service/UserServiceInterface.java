package com.sitrus.user.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitrus.user.model.User;

public interface UserServiceInterface extends JpaRepository<String, Long> {

	public Optional<User> findUserByEmail(String email);

	public void save(User user);

}
