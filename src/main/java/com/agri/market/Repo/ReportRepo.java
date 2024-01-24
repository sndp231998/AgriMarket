package com.agri.market.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.agri.market.entities.Report;
import com.agri.market.entities.User;

public interface ReportRepo extends JpaRepository<Report, Integer> {
	List<Report> findByUser(User user);
	
}
