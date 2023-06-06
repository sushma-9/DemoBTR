package com.jspr.dao;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspr.dto.User;
import com.jspr.repo.UserRepo;
@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;
	//save
	public User saveUser(User user) {
		return repo.save(user);
	}
	//find
	public User findUser(int id) {
		Optional<User> option = repo.findById(id);
//		User user = repo.findById(id).get();
//		return user;
		return option.get();
	}
	//findAll
	public List<User> findAllUsers() {
		return repo.findAll();
	}
	//update
	public User updateUser(int id, User user) {
		Optional<User> user1 = repo.findById(id);
		if(user1.isPresent() )
		{
			user.setUserId(id);
			return repo.save(user);
		}
		return null;
	}
	//delete
	public User deleteUser(int id) {
		Optional<User> user2 = repo.findById(id);
		if(user2.isPresent() )
		{
			repo.deleteById(id);
			return user2.get();
		}
		return null;
	}
	//getUserByEmail
	public User getUserByEmailWOPassword(String email) {
		User user = repo.getUserByEmailWOPassword(email);
		if(user!=null) {
			return user;
	}
	return null;
	}
	
	//getUserByEmailPassword
	public User getUserByEmail(String email) {
		User user = repo.getUserByEmail(email);
		if(user!=null) {
			return user;
	}
	return null;
	}
}
