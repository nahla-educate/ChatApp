package com.example.demo.services;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.message.LoginMessage;

public interface UserService {
	String addUser(UserDto userDto);

	LoginMessage loginUser(LoginDto loginDto);

}
