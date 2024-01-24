package com.agri.market.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="market")
@NoArgsConstructor
@Data
@Entity
public class Market {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Mid;

	@NotEmpty(message = "productname must not be null")
	private String ProductName;
	

	@NotEmpty(message = "Quantity must not be null")
	private String Qty;

	
	@NotEmpty(message="Location Required")
	private String location;
	
	private Date addedDate;
	
	@ManyToOne
	private User user;

}
