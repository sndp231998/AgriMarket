package com.agri.market.playloads;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;

	
	@NotEmpty
	@Size(min = 4, message = "name must be min of 4 characters !!")
	private String name;

	@Email(message = "Email address is not valid !!")
	@NotEmpty(message = "Email is required !!")
	private String email;

	@NotEmpty(message = "Your municipility  must required")
	private String municipilty;
	
	@NotEmpty(message = "Your tole name must required")
	private String tole;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
	private String password;
	
	@Column(name = "phone", length = 10)
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	private String phone;
	
	@NotEmpty(message = "userType must required")
	private String userType;
	
	


	
	
}