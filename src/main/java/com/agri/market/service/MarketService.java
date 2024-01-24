package com.agri.market.service;

import java.util.List;

import com.agri.market.playloads.MarketDto;

public interface MarketService {
	
	//create
	 MarketDto   CreateMarket(MarketDto marketdto,Integer userId);
	 
		////update 
		 MarketDto updateMarket(MarketDto marketdto, Integer Mid);
		  
		 List<MarketDto>getAllMarkets();
		 
		//get all market//items by user
			List<MarketDto> getMarketsByUser(Integer userId);
			
}
