package com.agri.market.playloads;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	//private int status;
    private String message;
   // private Object result;
    private boolean success;
    private String name;
    private Integer id;
    private String useType;
    
    

}
