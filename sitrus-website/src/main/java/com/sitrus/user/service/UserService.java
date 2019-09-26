package com.sitrus.user.service;


import java.util.*;



import com.sitrus.user.model.User;


public interface UserService {
public Optional<User> findUserByEmail(String email);
public Optional<User> findUserById(int id);
public void save(User user);

}
