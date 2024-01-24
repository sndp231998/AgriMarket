package com.agri.market.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agri.market.entities.*;
import com.agri.market.Repo.EquipmentRepo;
import com.agri.market.Repo.UserRepo;
import com.agri.market.entities.Equipment;
import com.agri.market.exception.ResourceNotFoundException;
import com.agri.market.playloads.EquipmentDto;
import com.agri.market.service.EquipmentService;


@Service
public class EquipmentServiceImpl implements EquipmentService{

	
	@Autowired
    private EquipmentRepo equipmentRepo;
	
	 @Autowired
	    private UserRepo userRepo;

	 
	 @Autowired
	    private ModelMapper modelMapper;

	 
	@Override
	public EquipmentDto CreateEquipment(EquipmentDto equipmentDto, Integer userId) {
		User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));
		
		  Equipment equipment = this.modelMapper.map(equipmentDto, Equipment.class);
		  equipment.setAddedDate(new Date());
	        equipment.setUser(user);
	        Equipment newEquipment = this.equipmentRepo.save(equipment);

	        return this.modelMapper.map(newEquipment, EquipmentDto.class);
		
	}

	@Override
	public EquipmentDto updateEquipment(EquipmentDto equipmentdto, Integer equipmentId) {
		 Equipment equipment = this.equipmentRepo.findById(equipmentId)
	                .orElseThrow(() -> new ResourceNotFoundException("Equipment ", "equipment id", equipmentId));

             
	        equipment.setServicetype(equipmentdto.getServicetype());
	        equipment.setLocation(equipmentdto.getLocation());
	        equipment.setAddedDate(equipmentdto.getAddedDate());
	        equipment.setPhone(equipmentdto.getPhone());
	        equipment.setPropose(equipmentdto.getPropose());
	        Equipment updatedEquipment = this.equipmentRepo.save(equipment);
	        return this.modelMapper.map(updatedEquipment, EquipmentDto.class);
	    }
	
	
	

	@Override
	public List<EquipmentDto> getEquipmentsByUser(Integer userId) {
		 User user = this.userRepo.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
	        List<Equipment> equipments = this.equipmentRepo.findByUser(user);

	        List<EquipmentDto> equipmentDtos = equipments.stream().map((equipment) -> this.modelMapper.map(equipment, EquipmentDto.class))
	                .collect(Collectors.toList());

	        return equipmentDtos;
	}

	public Equipment dtoToEquipment(EquipmentDto equipmentDto) {
		Equipment equipment = this.modelMapper.map(equipmentDto, Equipment.class);

		
		return equipment;
	}

	public EquipmentDto equipmentToDto(Equipment equipment) {
		EquipmentDto equipmentDto = this.modelMapper.map(equipment, EquipmentDto.class);
		return equipmentDto;
	}
	
	
	
//	@Override
//	public List<Equipment> getAllEquipments() {
//		List<Equipment> equipments = this.equipmentRepo.findAll();
//		List<EquipmentDto> equipmentDtos = equipments.stream().map(equipment -> this.equipmentToDto(equipment)).collect(Collectors.toList());
//		return equipmentDtos;
//	}
	@Override
	public List<EquipmentDto> getAllEquipments() {
	    List<Equipment> equipments = this.equipmentRepo.findAll();
	    List<EquipmentDto> equipmentDtos = equipments.stream()
	            .map(equipment -> this.equipmentToDto(equipment))
	            .collect(Collectors.toList());
	    return equipmentDtos;
	}


	
}
