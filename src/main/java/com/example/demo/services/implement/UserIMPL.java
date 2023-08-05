package com.example.demo.services.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.message.LoginMessage;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import com.example.demo.services.UserService;


@Service
public class UserIMPL implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public String addUser(UserDto userDto) {
		
		User user = new User(
				userDto.getUserId(),
				userDto.getUserMail(),
				userDto.getUserName(),
				this.passwordEncoder.encode(userDto.getUserPassword())
				);
		
		userRepository.save(user);
		
		return user.getUserName();
	}


	@Override
	public LoginMessage loginUser(LoginDto loginDto) {
		String msg = "";
        User user = userRepository.findByEmail(loginDto.getUserMail());
        if (user != null) {
            String password = loginDto.getUserPassword();
            String encodedPassword = user.getUserPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user1 = userRepository.findOneByEmailAndPassword(loginDto.getUserMail(), encodedPassword);
                if (user1.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
	

}
