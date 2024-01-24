package com.agri.market.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="user")
@NoArgsConstructor
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_name", nullable = false, length = 100)
	private String name;

	@Column(unique = true)
	@NotEmpty(message = "email must required")
	private String email;
	
	@NotEmpty(message = "Your municipility  must required")
	private String municipilty;
	
	@NotEmpty(message = "Your tole name must required")
	private String tole;
    
	@NotEmpty(message = "password must required")
	private String password;
	
	@Column(name = "phone", length = 10)
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	private String phone;
	
	@NotEmpty(message = "userType must required")
	private String userType;
	
	

}
