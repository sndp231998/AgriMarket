package com.agri.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agri.market.playloads.EquipmentDto;
import com.agri.market.playloads.MarketDto;
import com.agri.market.service.EquipmentService;
//123
@RestController
@RequestMapping("/api/v1/")
public class EquipmentController {
	
	
	@Autowired
	private EquipmentService equipmentService;


//	create
	@PostMapping("/user/{userId}/requestservices")
	public ResponseEntity<EquipmentDto> CreateEquipment(@RequestBody EquipmentDto equipmentDto, @PathVariable Integer userId) {
		EquipmentDto createEquipment = this.equipmentService.CreateEquipment(equipmentDto, userId);
		return new ResponseEntity<EquipmentDto>(createEquipment, HttpStatus.CREATED);
	}
	// update Equipment

		@PutMapping("/equipments/{EquipmentId}")
		public ResponseEntity<EquipmentDto> updateEquipment(@RequestBody EquipmentDto equipmentDto, @PathVariable Integer equipmentId) {

			EquipmentDto updateEquipment = this.equipmentService.updateEquipment(equipmentDto, equipmentId);
			return new ResponseEntity<EquipmentDto>(updateEquipment, HttpStatus.OK);

		}
		
		// get by user

		@GetMapping("/user/{userId}/requestedservices")
		public ResponseEntity<List<EquipmentDto>> getEquipmentsByUser(@PathVariable Integer userId) {

			List<EquipmentDto> equipments = this.equipmentService.getEquipmentsByUser(userId);
			return new ResponseEntity<List<EquipmentDto>>(equipments, HttpStatus.OK);

		}

		// GET - All requested services//selled get
					@GetMapping("/requestedservices")
					public ResponseEntity<List<EquipmentDto>> getAllEquipments() {
						return ResponseEntity.ok(this.equipmentService.getAllEquipments());
					}
}
