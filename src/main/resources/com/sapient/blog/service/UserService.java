package com.sapient.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.blog.dao.BlogDAO;
import com.sapient.blog.model.User;
import com.sapient.blog.repository.UserRepository;

@Service(value = "userService")
public class UserService {
	
//	@Autowired
//	@Qualifier(value = "userRepo")
//	private UserRepository userRepository;
	
	@Autowired
	@Qualifier(value = "hibernateDAO")
	private BlogDAO dao;
	
	@Transactional
	public User getUserById(long id) {
		return dao.getUserById(id);
	}
	
	@Transactional
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	@Transactional
	public User deleteUser(long id) {
		return dao.deleteUser(id);
	}
	@Transactional
	public List<User> getAll(){
		return dao.getAllUser();
	}
	@Transactional
	public User updateUser(User user, long id) {
		return dao.updateUser(user,id);
	}
}
