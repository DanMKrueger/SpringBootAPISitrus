package com.sitrus.user.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sitrus.user.model.User;

@Repository("userRepository") 
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	Optional<User> findById(int id);
	
	
}
