package com.agri.market.playloads;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class EquipmentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceid;

	@NotEmpty(message="service type must required")
	private String servicetype;

	@NotEmpty
	private String location;
    
	
	private Date addedDate;
	
	@NotEmpty
	private String phone;
	@NotEmpty
	private String Propose;
}
