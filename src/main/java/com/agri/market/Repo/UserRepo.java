package com.agri.market.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.market.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
