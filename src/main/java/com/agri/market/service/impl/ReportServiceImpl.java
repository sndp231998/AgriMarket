package com.agri.market.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agri.market.Repo.ReportRepo;
import com.agri.market.Repo.UserRepo;
import com.agri.market.entities.Market;
import com.agri.market.entities.Report;
import com.agri.market.entities.User;
import com.agri.market.exception.ResourceNotFoundException;
import com.agri.market.playloads.MarketDto;
import com.agri.market.playloads.ReportDto;
import com.agri.market.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	
	@Autowired
    private ReportRepo reportRepo;
	
	 @Autowired
	    private UserRepo userRepo;
      
	 
	 
	 @Autowired
	    private ModelMapper modelMapper;



	@Override
	public ReportDto CreateReport(ReportDto reportdto, Integer userId) {
		User user = this.userRepo.findById(userId)
			      .orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));

			        Report report = this.modelMapper.map(reportdto, Report.class);
			      report.setAddedDate(new Date());
			  report.setUser(user);
			  Report newreport = this.reportRepo.save(report);

			  return this.modelMapper.map(newreport, ReportDto.class);
	}



	@Override
	public List<ReportDto> getAllReports() {
		List<Report> reports = this.reportRepo.findAll();
	    List<ReportDto> reportDtos = reports.stream()
	            .map(report -> this.reportToDto(report))
	            .collect(Collectors.toList());
	    return reportDtos;
	}

	public Report dtoToreport(ReportDto reportDto) {
		Report report = this.modelMapper.map(reportDto, Report.class);

		
		return report;
	}

	public ReportDto reportToDto(Report report) {
		ReportDto reportDto = this.modelMapper.map(report, ReportDto.class);
		return reportDto;
	}
	

	@Override
	public List<ReportDto> getReportsByUser(Integer userId) {
		 User user = this.userRepo.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
	        List<Report> reports = this.reportRepo.findByUser(user);
	        List<ReportDto> reportDtos = reports.stream().map((report) -> this.modelMapper.map(report, ReportDto.class))
	                .collect(Collectors.toList());

	        return reportDtos;
	}

}
