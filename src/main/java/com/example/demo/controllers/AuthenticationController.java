package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.AuthenticationRequest;
import com.example.demo.message.AuthenticationResponse;
import com.example.demo.message.RegisterRequest;
import com.example.demo.models.User;
import com.example.demo.services.AuthenticaionService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	//look here
	private final AuthenticaionService service;
	 @Autowired // or @Inject
	    public AuthenticationController(AuthenticaionService service) {
	        this.service = service;
	    }
	 
	/* @PostMapping("/search")
	    public ResponseEntity<User> searchUserByUsername(@RequestBody String userName) {
	        User user = service.getUserByUsername(userName);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }*/
	 @GetMapping("/list")
	    public List<User> getAllUsers() {
	        return service.listAll();
	    }

	 @GetMapping("/users")
	    public ResponseEntity<User> getUserByUsername(@RequestParam String userName) {
	        User user = service.findByUserName(userName);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }



	  @PostMapping("/register")
	  public ResponseEntity<AuthenticationResponse> register(
	      @RequestBody RegisterRequest request
	  ) {
	    return ResponseEntity.ok(service.register(request));
	  }
	  @PostMapping("/authenticate")
	  public ResponseEntity<AuthenticationResponse> authenticate(
	      @RequestBody AuthenticationRequest request
	  ) {
	    return ResponseEntity.ok(service.authenticate(request));
	  }

	 /* @PostMapping("/refresh-token")
	  public void refreshToken(
	      HttpServletRequest request,
	      HttpServletResponse response
	  ) throws IOException {
	    service.refreshToken(request, response);
	  }*/

}
