package com.sample.service;

import java.util.List;

import com.sample.entity.User;

public interface UserService {
	
	User createUser(User user);
	User getUserId(Long userId);
	List<User> getAllUsers();
	User updateUser(User user);
	void deleteUser(Long userId);

}
