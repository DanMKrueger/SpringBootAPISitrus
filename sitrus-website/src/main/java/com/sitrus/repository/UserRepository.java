package com.sitrus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sitrus.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
}
