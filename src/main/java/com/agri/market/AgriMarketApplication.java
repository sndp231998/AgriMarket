package com.agri.market;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.agri.market")
@SpringBootApplication
public class AgriMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriMarketApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
