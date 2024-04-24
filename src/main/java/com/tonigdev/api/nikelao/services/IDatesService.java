package com.tonigdev.api.nikelao.services;

import org.springframework.http.ResponseEntity;

import com.tonigdev.api.nikelao.model.Dates;
import com.tonigdev.api.nikelao.request.DatesClientRequest;
import com.tonigdev.api.nikelao.responses.DatesResponseRest;

public interface IDatesService {
	
	public ResponseEntity<DatesResponseRest> getDates();
	
	public ResponseEntity<DatesResponseRest> getDateById(Long id);
	
	public ResponseEntity<DatesResponseRest> getDatesNotAvailable(String date);
	
	public ResponseEntity<DatesResponseRest> getDatesToday(String date);

	public ResponseEntity<DatesResponseRest> addDates(DatesClientRequest request);
	
	public ResponseEntity<DatesResponseRest> cancelDates(Dates date);
	
	public ResponseEntity<DatesResponseRest> finishDates(Dates date);
	
	public ResponseEntity<DatesResponseRest> deleteDate(Long id);

}
