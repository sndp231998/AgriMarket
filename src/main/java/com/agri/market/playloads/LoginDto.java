package com.agri.market.playloads;

import com.agri.market.entities.User;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
    @ManyToOne
	private User user;

 
//    public void setUsername(String username) {
//        this.username = username;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
}
