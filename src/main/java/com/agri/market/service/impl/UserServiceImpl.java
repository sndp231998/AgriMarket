package com.agri.market.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agri.market.Repo.UserRepo;
import com.agri.market.entities.User;
import com.agri.market.exception.ResourceNotFoundException;
import com.agri.market.playloads.ApiResponse;
import com.agri.market.playloads.LoginDto;
import com.agri.market.playloads.UserDto;
import com.agri.market.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	


	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUserType(userDto.getUserType());
		user.setTole(userDto.getTole());
		user.setMunicipilty(userDto.getMunicipilty());
        user.setPhone(userDto.getPhone());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	
//	@Override
//	public UserDto getUserByEmailAndPassword(String email, String password) {
//		User user=this.userRepo.getUserByEmailAndPassword(email, password);
//		if(user!=null) {
//			 UserDto userDto = modelMapper.map(user, UserDto.class);
//	            return userDto;	
//		}
//		else {
//			System.out.println("User not found");
//			return null;
//		}
//	}

	
	
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);

	}
	

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		return user;
	}
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	

	@Override
	public UserDto registerNewUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		// encoded the password
	//	user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// roles
		
		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public ApiResponse login(LoginDto loginDto) {
		 User user = userRepo.findByEmail(loginDto.getEmail());
	        if (user == null) {
	            throw new RuntimeException((loginDto.getPassword()));
	            }else
	                if (user.getPassword().equals(loginDto.getPassword())) {
	                	  int userId = user.getId();
	                	  String name=user.getName();
	                	  System.out.print(name);
	                	return new ApiResponse("Login Success",true, name, userId);
	        }else
	        throw new RuntimeException("Password mismatch.");

	        }

	}
	





