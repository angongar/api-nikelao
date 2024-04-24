package com.tonigdev.api.nikelao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.model.Dates;
import com.tonigdev.api.nikelao.model.StateDate;
import com.tonigdev.api.nikelao.request.DatesClientRequest;
import com.tonigdev.api.nikelao.request.DatesRequest;
import com.tonigdev.api.nikelao.responses.DatesResponseRest;
import com.tonigdev.api.nikelao.services.IDatesService;
import com.tonigdev.api.nikelao.utils.NikelaoDateUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-nikelao")
@RequiredArgsConstructor
public class DatesController {
	
	private final IDatesService service;
	
	@GetMapping("/dates")
	public ResponseEntity<DatesResponseRest> dates(@RequestParam("date") String date){
		return service.getDatesNotAvailable(date);
	}
	
	@PostMapping("/dates")
	public ResponseEntity<DatesResponseRest> addDatesClient(@RequestBody DatesClientRequest request){
		return service.addDates(request);
	}
	
	@GetMapping("/datestoday")
	public ResponseEntity<DatesResponseRest> datestoday(){		
		return service.getDatesToday(NikelaoDateUtils.getDateToday());
	}
	
	@PutMapping("/canceldates")
	public ResponseEntity<DatesResponseRest> canceldates(@RequestBody DatesRequest request){		
		return service.cancelDates(request.getDate());
	}
	
	@PutMapping("/finishdates")
	public ResponseEntity<DatesResponseRest> finishdates(@RequestBody DatesRequest request){		
		return service.finishDates(request.getDate());
	}

}
