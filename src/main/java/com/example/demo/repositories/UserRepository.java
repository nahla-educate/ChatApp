package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("SELECT u FROM User u WHERE u.userMail = :userMail AND u.userPassword = :userPassword")
	Optional<User> findOneByEmailAndPassword(@Param("userMail") String userMail, @Param("userPassword") String userPassword);

	@Query("SELECT u FROM User u WHERE u.userMail = :userMail")
	User findByEmail(@Param("userMail") String userMail);
	
	  User findByUserMail(String userMail);
	    User findByUserName(String userName);
	  
	  boolean existsByUserMail(String userMail);
}
