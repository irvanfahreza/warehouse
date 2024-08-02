package com.warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.entity.User;
import com.warehouse.warehouse.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/new")
	public ResponseEntity<String> newUser(@RequestBody @Valid User user) {
		
		User save = userService.newUser(user);
		return ResponseEntity.ok("User berhasil ditambahkan");
	}
}
