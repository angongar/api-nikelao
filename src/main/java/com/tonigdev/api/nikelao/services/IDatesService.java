package com.tonigdev.api.nikelao.services;

import org.springframework.http.ResponseEntity;

import com.tonigdev.api.nikelao.model.Dates;

public interface IDatesService {
	
	public ResponseEntity<?> getDates();
	
	public ResponseEntity<?> getDateById(Long id);
	
	public ResponseEntity<?> addDates(Dates date);
	
	public ResponseEntity<?> deleteDate(Long id);

}
