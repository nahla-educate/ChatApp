package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.message.LoginMessage;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping(path="/signUp")
	public String saveUser(@RequestBody UserDto userDto) {
		String id = userService.addUser(userDto);
		return id;
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
		LoginMessage loginMsg = userService.loginUser(loginDto);
		return ResponseEntity.ok(loginMsg);
	}
}
