package com.tonigdev.api.nikelao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tonigdev.api.nikelao.model.Horary;
import com.tonigdev.api.nikelao.repositories.IHoraryRepository;
import com.tonigdev.api.nikelao.responses.HoraryResponseRest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HoraryService implements IHoraryService {
	
	private final IHoraryRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<HoraryResponseRest> getHorary() {
		ResponseEntity<HoraryResponseRest> response = null;
		HoraryResponseRest apiResponse = new HoraryResponseRest();
		List<Horary> listHorary;
		
		try {
			
			listHorary = repository.findAll();
			
			if(listHorary != null && !listHorary.isEmpty()) {
				apiResponse.setMessage("Se han obtenido correctamente los datos");
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setResults(listHorary);
				
				response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.OK);
				
			}else {
				apiResponse.setMessage("No hay datos.");
				apiResponse.setStatus(HttpStatus.NOT_FOUND);
				
				response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.NOT_FOUND);
			}
			
			
		}catch (Exception e) {
			log.error("HoraryService.getHorary() - Se ha producido un error al obtener los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al obtener los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			
			response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}

	@Override
	public ResponseEntity<HoraryResponseRest> addHour(Horary horary) {
		ResponseEntity<HoraryResponseRest> response = null;
		HoraryResponseRest apiResponse = new HoraryResponseRest();
		Horary horaryInsert;
		List<Horary> listHorary;
		 
		try {
			
			horaryInsert = repository.save(horary);
			
			if(horaryInsert != null) {
				listHorary = new ArrayList<>();
				listHorary.add(horaryInsert);
				
				apiResponse.setMessage("Se ha añadido correctamente la nueva hora.");
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setResults(listHorary);
				
				response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.OK);
			}else {
				apiResponse.setMessage("No se ha podido añadir la nueva hora.");
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				
				response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.BAD_REQUEST);
			}
			
		}catch (Exception e) {
			log.error("HoraryService.addHour(horary) - Se ha producido un error al insertar los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al insertar los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			
			response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@Override
	public ResponseEntity<HoraryResponseRest> deleteHour(Long id) {
		ResponseEntity<HoraryResponseRest> response = null;
		HoraryResponseRest apiResponse = new HoraryResponseRest();
		
		
		try {
			
			repository.deleteById(id);
			
			apiResponse.setMessage("Se ha eliminado la hora correctamente.");
			apiResponse.setStatus(HttpStatus.OK);
			
			response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("HoraryService.deleteHour(id) - Se ha producido un error al eliminar los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al eliminar los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			
			response = new ResponseEntity<HoraryResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
	}

}
