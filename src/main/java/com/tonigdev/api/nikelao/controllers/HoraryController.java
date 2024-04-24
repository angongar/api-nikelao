package com.tonigdev.api.nikelao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tonigdev.api.nikelao.model.Horary;
import com.tonigdev.api.nikelao.responses.HoraryResponseRest;
import com.tonigdev.api.nikelao.services.IHoraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-nikelao")
@RequiredArgsConstructor
public class HoraryController {

	private final IHoraryService service;
	
	@GetMapping("/horary")
	public ResponseEntity<HoraryResponseRest> horary(){
		return service.getHorary();
	}
	
	@PostMapping("/horary")
	public ResponseEntity<HoraryResponseRest> addHour(@RequestBody Horary horary){
		return service.addHour(horary);
	}
	
	@DeleteMapping("/horary")
	public ResponseEntity<HoraryResponseRest> deleteHour(@RequestParam Long id){
		return service.deleteHour(id);
	}
	
}
