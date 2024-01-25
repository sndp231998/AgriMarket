package com.agri.market.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agri.market.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	 User findByPassword(String password);

	    User findByEmail(String email);
	    
	   // User findById(Integer id);
	
	//@Query("select u from User u where u.email = :email and u.password = :password")
	//public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}
