package com.example.demo.security.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "W3oMkvGZxr/qEMv4U5aC09rmyWweRt6LJSnM+95jSUs5wBWNd0DsqnR5THh5DzJyYpR3/+jCf//3OTwls91CEd8580lQ5fsyWOBB2A+yYPnk0Fcuw4JK/WVwvGxVqs3betsf1LIHuX9MH95rGAIYerGuvAyVZmbhQWVbsJ6KbbicQZ1Xgp7WgO+Ppp3/exro7n8JvBOJCkIKnG65jDtM6EmNEFVFaR8b55kQo2svBUFAlOZVyXdGxeKIkMPM2/hTCHsoyinXKdv5/q0ATQWw6r7u3gVMXhelZxJJDzUss2vAh01oWhc22ARlyV+V8bC1VTYPH7TIbSLITtz4HJfLj868z+qzs3gxy6yPdyiM3B0=\r\n";

	public String extractUsername(String token) {
		
		return extractClaim(token, Claims::getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
	    return claimsResolver.apply(claims);
	}
	
	public String generateToken(UserDetails userDetails) {
	    return generateToken(new HashMap<>(), userDetails);
	  }

	
	public String generateToken(
			Map<String, Object> extraClaims,
			UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 ))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
				  //to know when the token expire
				// valide 24h);
	}
	
	 public boolean isTokenValid(String token, UserDetails userDetails) {
		    final String username = extractUsername(token);
		    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
		  }

		
	 private boolean isTokenExpired(String token) {
		    return extractExpiration(token).before(new Date());
		  }

		  
	 private Date extractExpiration(String token) {
		    return extractClaim(token, Claims::getExpiration);
		  }
	
	
	 private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	 }
	
	 private Key getSignInKey() {
		byte[] keyButes = Decoders.BASE64.decode(SECRET_KEY);
				return Keys.hmacShaKeyFor(keyButes);
	 }

}
