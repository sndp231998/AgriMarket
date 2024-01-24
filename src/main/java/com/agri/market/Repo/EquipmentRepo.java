package com.agri.market.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.market.entities.Equipment;
import com.agri.market.entities.User;




public interface EquipmentRepo  extends JpaRepository<Equipment, Integer>{
	List<Equipment> findByUser(User user);
	
}
