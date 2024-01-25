package com.agri.market.service;

import java.util.List;

import com.agri.market.playloads.ApiResponse;
import com.agri.market.playloads.LoginDto;
import com.agri.market.playloads.UserDto;


public interface UserService {


	UserDto registerNewUser(UserDto user);
	
	 ApiResponse login(LoginDto loginDto);
	//UserDto getUserByEmailAndPassword(String email, String password);
	
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}
