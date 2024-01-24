package com.agri.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agri.market.playloads.MarketDto;
import com.agri.market.playloads.ReportDto;
import com.agri.market.service.ReportService;

@RestController
@RequestMapping("/api/v1/")
public class ReportController {

	@Autowired
	private ReportService reportService;
	

//	create
	@PostMapping("/user/{userId}/reports")
	public ResponseEntity<ReportDto> CreateReport(@RequestBody ReportDto reportDto, @PathVariable Integer userId) {
		ReportDto createreport = this.reportService.CreateReport(reportDto, userId);
		return new ResponseEntity<ReportDto>(createreport, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/reports")
	public ResponseEntity<List<ReportDto>> getReportsByUser(@PathVariable Integer userId) {

		List<ReportDto> Reports = this.reportService.getReportsByUser(userId);
		return new ResponseEntity<List<ReportDto>>(Reports, HttpStatus.OK);

	}
	// GET - All report//selled get
				@GetMapping("/reports")
				public ResponseEntity<List<ReportDto>> getAllReports() {
					return ResponseEntity.ok(this.reportService.getAllReports());
				}
	
	
}
