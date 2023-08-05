package com.example.demo.services;

	import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;

	import com.example.demo.message.AuthenticationRequest;
	import com.example.demo.message.AuthenticationResponse;
	import com.example.demo.message.RegisterRequest;
	import com.example.demo.models.Role;
	import com.example.demo.models.User;
	import com.example.demo.repositories.UserRepository;
	import com.example.demo.security.config.JwtService;
	import com.fasterxml.jackson.databind.ObjectMapper;


	@Service

public class AuthenticaionService { 
		
		 private final UserRepository repository;
		  private final PasswordEncoder passwordEncoder;
		  private final JwtService jwtService;
		  private final AuthenticationManager authenticationManager;
		  
		  
		public AuthenticaionService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
				AuthenticationManager authenticationManager) {
			super();
			this.repository = repository;
			this.passwordEncoder = passwordEncoder;
			this.jwtService = jwtService;
			this.authenticationManager = authenticationManager;
		}
		 public User findByUserName(String userName) {
		        return repository.findByUserName(userName);
		    }
		 public User get(long id) {
		        return repository.findById(id).get();
		    }
		 
		 public List<User> listAll() {
		        return repository.findAll();
		    }

		public AuthenticationResponse register(RegisterRequest request) {
			    
			    // Check if the user already exists in the database
			    String userMail = request.getUserMail();
			     if (repository.existsByUserMail(userMail)) {
			    	   throw new IllegalArgumentException("User already exists.");
			     }
			     User user = new User(	
			    		 
			    		 request.getUserMail(), request.getUserName(),
			    		 this.passwordEncoder.encode(request.getUserPassword()), 
			                        Role.USER);
			    repository.save(user);
			    
			   
			    String jwtToken = jwtService.generateToken(user);
			    
			    AuthenticationResponse response = new AuthenticationResponse();
			    response.setToken(jwtToken);
			    return response;
		}
		
		public AuthenticationResponse authenticate(AuthenticationRequest request) {
		    authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(
		            request.getUserMail(),
		            request.getUserPassword()
		        )
		    );
		    UserDetails user = repository.findByEmail(request.getUserMail());
		    if (user == null) {
		        throw new IllegalArgumentException("User not found with email: " + request.getUserMail());
		    }
		    String jwtToken = jwtService.generateToken((User) user);
		    AuthenticationResponse response = new AuthenticationResponse();
		    response.setToken(jwtToken);
		    return response;
		}

		/*public AuthenticationResponse authenticate(AuthenticationRequest request) {
		    authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(
		            request.getUserMail(),
		            request.getUserPassword()
		        )
		    );
		    UserDetails user = repository.findByEmail(request.getUserMail());
		    if (user == null) {
		        throw new IllegalArgumentException("User not found with email: " + request.getUserMail());
		    }
		    String jwtToken = jwtService.generateToken((User) user);
		    AuthenticationResponse response = new AuthenticationResponse();
		    response.setToken(jwtToken);
		    return response;
		}  */
	}

