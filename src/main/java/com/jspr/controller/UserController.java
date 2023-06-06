package com.jspr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspr.config.ResponseStructure;
import com.jspr.dto.User;
import com.jspr.service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService service;
	//save
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	//find
	@GetMapping("/find")
	public User findUser(@RequestParam int id) {
		return service.findUser(id);
	}
	//findAll
	@GetMapping("/findAll")
	public List<User> findAllUsers(){
		return service.findAllUsers();
	}
	//update
	@PutMapping("/update")
	public ResponseStructure<User> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id,user);
	}
	//delete
	@DeleteMapping("/delete")
	public ResponseStructure<User> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	//getUserByEmail
	@GetMapping("/email")
	public ResponseStructure<User>findByEmailWOPassword(@RequestParam String userEmail) {
		return service.findByEmailWOPassword(userEmail);
	}
	
	@GetMapping("/user")
	public ResponseStructure<User>findByEmail(@RequestParam String userEmail,@RequestParam String userPassword) {
		return service.findByEmail(userEmail, userPassword);
	}
}