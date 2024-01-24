package com.agri.market.playloads;


import jakarta.persistence.Column;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ReportDto {
	
	private int rid;
	
	@Column(name = "phone", length = 10)
	@Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	private String phone;
	
	@NotEmpty(message = "Discribe Your problem  must required")
	private String problem;
	
}
