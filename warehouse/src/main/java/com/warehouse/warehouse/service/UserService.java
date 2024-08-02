package com.warehouse.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.entity.User;
import com.warehouse.warehouse.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User newUser(User user) {
		return userRepo.save(user);
	}
}
