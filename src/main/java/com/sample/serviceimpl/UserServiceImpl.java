package com.sample.serviceimpl;


import java.util.List;
import java.util.Optional;

import com.sample.entity.User;
import com.sample.repository.UserRepository;
import com.sample.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserId(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> op = userRepository.findById(userId);
		return op.get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		User updateUser = userRepository.save(existingUser);
		return updateUser;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}	

}



