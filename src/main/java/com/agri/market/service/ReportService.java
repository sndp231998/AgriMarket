package com.agri.market.service;

import java.util.List;


import com.agri.market.playloads.ReportDto;

public interface ReportService {

	
	//create
		 ReportDto   CreateReport(ReportDto reportdto,Integer userId);
		 
		 List<ReportDto>getAllReports();
		 
			//get all market//items by user
				List<ReportDto> getReportsByUser(Integer userId);
}
