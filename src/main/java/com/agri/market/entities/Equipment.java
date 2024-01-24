package com.agri.market.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="service")
@NoArgsConstructor
@Data
@Entity

public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceid;

	@NotEmpty(message="servicetype must required")
	private String servicetype;

	@NotEmpty(message = "Location must not be empty")
	private String location;

	@NotEmpty(message="phone number required")
	private String phone;
	
	@NotEmpty(message="propose is required")
	private String Propose;

	private Date addedDate;
	
//	@NotEmpty(message = "Service type must be provided")
//    private String serviceType;
//	
	@ManyToOne
	private User user;
}
