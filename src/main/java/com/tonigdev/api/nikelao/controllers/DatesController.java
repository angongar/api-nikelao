package com.tonigdev.api.nikelao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.model.Dates;
import com.tonigdev.api.nikelao.model.StateDate;
import com.tonigdev.api.nikelao.request.DatesClientRequest;
import com.tonigdev.api.nikelao.responses.DatesResponseRest;
import com.tonigdev.api.nikelao.services.IDatesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-nikelao")
@RequiredArgsConstructor
public class DatesController {
	
	private final IDatesService service;
	
	@GetMapping("/dates")
	public ResponseEntity<DatesResponseRest> dates(@RequestParam("date") String date){
		return service.getDatesAvailable(date);
	}
	
	@PostMapping("/dates")
	public ResponseEntity<DatesResponseRest> addDatesClient(@RequestBody DatesClientRequest request){
		Dates dates = new Dates();
		Clients clients = new Clients();
		StateDate stateDate = new StateDate();
		
		clients.setId(request.getClientId());
		
		stateDate.setId(request.getStateDateId());
		
		dates.setDate(request.getDate());
		dates.setClient(clients);
		dates.setHorary(request.getHorary());
		dates.setStateDate(stateDate);
		
		return service.addDates(dates);
	}

}
