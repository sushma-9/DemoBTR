package com.jspr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspr.config.ResponseStructure;
import com.jspr.dao.UserDao;
import com.jspr.dto.User;
@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	public User user;
	//save
	public User saveUser(User user)
	{
		return dao.saveUser(user);
	}
	//find
	public User findUser(int id) {
		return dao.findUser(id);
	}
	//findAll
	public List<User> findAllUsers(){
		return dao.findAllUsers();
	}
	//update
	public ResponseStructure<User> updateUser(int id, User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updated successfully");
		responseStructure.setData(dao.updateUser(id, user));
		return responseStructure;
	}
	//delete
	public ResponseStructure<User> deleteUser(int id){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted successfully");
		responseStructure.setData(dao.deleteUser(id));
		return responseStructure;
	}
	//getUserByEmail
	public ResponseStructure<User> findByEmailWOPassword(String email){
	{	
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully fetched");
		responseStructure.setData(dao.getUserByEmailWOPassword(email));
		return responseStructure;
	}
	}
	
	public ResponseStructure<User> findByEmail(String email, String password){
		
		User user = dao.getUserByEmail(email);
		if( password.equals(user.getUserPassword()))
	{	
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched");
		responseStructure.setData(dao.getUserByEmail(email));
		return responseStructure;
	}
	return null;
	}

}
