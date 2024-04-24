package com.tonigdev.api.nikelao.services;

import org.springframework.http.ResponseEntity;

import com.tonigdev.api.nikelao.model.Horary;
import com.tonigdev.api.nikelao.responses.HoraryResponseRest;

public interface IHoraryService {
	
	public ResponseEntity<HoraryResponseRest> getHorary();
	
	public ResponseEntity<HoraryResponseRest> addHour(Horary horary);
	
	public ResponseEntity<HoraryResponseRest> deleteHour(Long id);

}
