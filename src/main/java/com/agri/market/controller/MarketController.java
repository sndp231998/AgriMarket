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


import com.agri.market.playloads.MarketDto;
import com.agri.market.service.MarketService;

@RestController
@RequestMapping("/api/v1/")
public class MarketController {

	
	@Autowired
	private MarketService marketService;

	
//	create
	@PostMapping("/user/{userId}/markets")
	public ResponseEntity<MarketDto> CreateMarket(@RequestBody MarketDto marketDto, @PathVariable Integer userId) {
		MarketDto createmarket = this.marketService.CreateMarket(marketDto, userId);
		return new ResponseEntity<MarketDto>(createmarket, HttpStatus.CREATED);
	}
	
	// update market

			@PutMapping("/markets/{marketId}")
			public ResponseEntity<MarketDto> updateMarket(@RequestBody MarketDto marketDto, @PathVariable Integer Mid) {

				MarketDto updateMarket = this.marketService.updateMarket(marketDto, Mid);
				return new ResponseEntity<MarketDto>(updateMarket, HttpStatus.OK);

			}
			
			
			// get by user

			@GetMapping("/user/{userId}/markets")
			public ResponseEntity<List<MarketDto>> getMarketsByUser(@PathVariable Integer userId) {

				List<MarketDto> Markets = this.marketService.getMarketsByUser(userId);
				return new ResponseEntity<List<MarketDto>>(Markets, HttpStatus.OK);

			}
			
			// GET - All market//selled get
			@GetMapping("/markets")
			public ResponseEntity<List<MarketDto>> getAllMarkets() {
				return ResponseEntity.ok(this.marketService.getAllMarkets());
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
