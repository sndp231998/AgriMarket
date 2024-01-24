package com.agri.market.service;

import java.util.List;

import com.agri.market.entities.Equipment;
import com.agri.market.playloads.EquipmentDto;




public interface EquipmentService {

	//create
	 EquipmentDto   CreateEquipment(EquipmentDto equipmentdto,Integer userId);
	 
	////update 
	 EquipmentDto updateEquipment(EquipmentDto equipmentdto, Integer equipmentId);
	  
	 List<EquipmentDto>getAllEquipments();
	 
	//get all serviceEquipments by user
		List<EquipmentDto> getEquipmentsByUser(Integer userId);
		
		

}
