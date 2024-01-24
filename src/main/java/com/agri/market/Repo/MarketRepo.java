package com.agri.market.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agri.market.entities.Market;
import com.agri.market.entities.User;

public interface MarketRepo extends JpaRepository<Market, Integer>{

	List<Market> findByUser(User user);
}
