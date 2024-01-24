package com.agri.market.playloads;
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
public class MarketDto {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int Mid;

	@NotEmpty(message = "productname  must not be null")
	private String ProductName;
	
	
	@NotEmpty(message = "Quantity must not be null")
	private String Qty;
	
	@NotEmpty(message="Location Required")
	private String location;
}
