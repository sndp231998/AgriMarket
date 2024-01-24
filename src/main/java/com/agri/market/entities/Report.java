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
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Reports")
@NoArgsConstructor
@Data
@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	
	@Column(name = "phone", length = 10)
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	private String phone;
	
	@NotEmpty(message = "Discribe Your problem  must required")
	private String problem;
	
	@ManyToOne
	private User user;
	
	private Date addedDate;
	

}
