package com.agri.market.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agri.market.Repo.MarketRepo;
import com.agri.market.Repo.UserRepo;

import com.agri.market.entities.Market;
import com.agri.market.entities.User;
import com.agri.market.exception.ResourceNotFoundException;

import com.agri.market.playloads.MarketDto;
import com.agri.market.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService{
	
	@Autowired
    private MarketRepo marketRepo;
	
	 @Autowired
	    private UserRepo userRepo;
      
	 
	 
	 @Autowired
	    private ModelMapper modelMapper;

	@Override
	public MarketDto CreateMarket(MarketDto marketdto, Integer userId) {
		User user = this.userRepo.findById(userId)
      .orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));

        Market market = this.modelMapper.map(marketdto, Market.class);
      market.setAddedDate(new Date());
  market.setUser(user);
  Market newMarket = this.marketRepo.save(market);

  return this.modelMapper.map(newMarket, MarketDto.class);
	}

	@Override
	public MarketDto updateMarket(MarketDto marketdto, Integer Mid) {
		 Market market = this.marketRepo.findById(Mid)
	                .orElseThrow(() -> new ResourceNotFoundException("Market ", "market id", Mid));

          market.setProductName(marketdto.getProductName());
          market.setQty(marketdto.getQty());
          market.setLocation(marketdto.getLocation());
	       
	        Market updatedMarket = this.marketRepo.save(market);
	        return this.modelMapper.map(updatedMarket, MarketDto.class);
		
	}

	

	@Override
	public List<MarketDto> getMarketsByUser(Integer userId) {
		 User user = this.userRepo.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
	        List<Market> markets = this.marketRepo.findByUser(user);

	        List<MarketDto> marketDtos = markets.stream().map((market) -> this.modelMapper.map(market, MarketDto.class))
	                .collect(Collectors.toList());

	        return marketDtos;
	}
	
	public Market dtoTomarket(MarketDto marketDto) {
		Market market = this.modelMapper.map(marketDto, Market.class);

		
		return market;
	}

	public MarketDto marketToDto(Market market) {
		MarketDto marketDto = this.modelMapper.map(market, MarketDto.class);
		return marketDto;
	}
	

	@Override
	public List<MarketDto> getAllMarkets() {
		 List<Market> markets = this.marketRepo.findAll();
		    List<MarketDto> marketDtos = markets.stream()
		            .map(market -> this.marketToDto(market))
		            .collect(Collectors.toList());
		    return marketDtos;
	}

	
}
