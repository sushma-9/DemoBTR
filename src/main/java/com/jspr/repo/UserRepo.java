package com.jspr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspr.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	//EmailWOPassword
	@Query("select u from User u where u.userEmail=?1")
	public User getUserByEmailWOPassword(String userEmail);
	
	//Email&Password
	@Query("select u from User u where u.userEmail=?1")
	public User getUserByEmail(String email);
}
