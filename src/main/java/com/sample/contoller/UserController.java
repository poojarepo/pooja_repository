package com.sample.contoller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.User;
import com.sample.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private UserService userSrevice;
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User saveUser = userSrevice.createUser(user);
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
	{
		User user = userSrevice.getUserId(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userSrevice.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@PutMapping("{id}")
	public ResponseEntity<User> update(@PathVariable("id") Long userId, @RequestBody User user)
	{
		user.setId(userId);
		User updatedUser = userSrevice.updateUser(user);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}

}
