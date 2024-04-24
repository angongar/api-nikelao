package com.tonigdev.api.nikelao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.model.Dates;
import com.tonigdev.api.nikelao.model.StateDate;
import com.tonigdev.api.nikelao.repositories.IDatesRepository;
import com.tonigdev.api.nikelao.request.DatesClientRequest;
import com.tonigdev.api.nikelao.responses.DatesResponseRest;
import com.tonigdev.api.nikelao.utils.APINikelaoConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DatesService implements IDatesService {

	private final IDatesRepository repository;

	@Override
	public ResponseEntity<DatesResponseRest> getDates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DatesResponseRest> getDateById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<DatesResponseRest> getDatesNotAvailable(String date) {
		log.info("DatesService.getDatesAvailable(date) - Inicio método.");
		ResponseEntity<DatesResponseRest> response = null;
		DatesResponseRest apiResponse = new DatesResponseRest();
		List<Dates> dateAvailables = new ArrayList<>();

		try {
			dateAvailables = repository.findByDateReservedFinish(date);

			apiResponse.setMessage("Se ha obtenido los datos correctamente");
			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setResults(dateAvailables);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.OK);

		} catch (Exception e) {
			log.error("DatesService.getDatesAvailable(date) - Se ha producido un error al obtener los datos: "
					+ e.getMessage());
			apiResponse.setMessage("Se ha producido un error al obtener los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<DatesResponseRest> getDatesToday(String date) {
		log.info("DatesService.getDatesToday(date) - Inicio método.");
		ResponseEntity<DatesResponseRest> response = null;
		DatesResponseRest apiResponse = new DatesResponseRest();
		List<Dates> dateAvailables = new ArrayList<>();

		try {
			dateAvailables = repository.findByDate(date);

			apiResponse.setMessage("Se ha obtenido los datos correctamente");
			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setResults(dateAvailables);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.OK);

		} catch (Exception e) {
			log.error("DatesService.getDatesToday(date) - Se ha producido un error al obtener los datos: "
					+ e.getMessage());
			apiResponse.setMessage("Se ha producido un error al obtener los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public ResponseEntity<DatesResponseRest> addDates(DatesClientRequest request) {
		log.info("DatesService.addDates(date) - Inicio método.");
		ResponseEntity<DatesResponseRest> response = null;
		DatesResponseRest apiResponse = new DatesResponseRest();
		List<Dates> listDates;
		Dates datesInsert;

		try {
			Dates date = new Dates();
			Clients client = new Clients();
			StateDate stateDate = new StateDate();
			
			client.setId(request.getClientId());
			
			stateDate.setId(request.getStateDateId());
			
			date.setDate(request.getDate());
			date.setClient(client);
			date.setHorary(request.getHorary());
			date.setStateDate(stateDate);
			
			datesInsert = repository.save(date);

			if (datesInsert != null) {
				listDates = new ArrayList<>();
				listDates.add(datesInsert);

				apiResponse.setMessage("Se ha reservado la cita correctamente");
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setResults(listDates);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.OK);
			} else {
				apiResponse.setMessage("No se ha podido realizar la reserva.");
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error(
					"DatesService.addDates(date) - Se ha producido un error al insertar los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al insertar los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public ResponseEntity<DatesResponseRest> cancelDates(Dates date) {
		log.info("DatesService.addDates(date) - Inicio método.");
		ResponseEntity<DatesResponseRest> response = null;
		DatesResponseRest apiResponse = new DatesResponseRest();
		List<Dates> listDates;
		Dates dateInsert;

		try {
			StateDate stateDate = new StateDate();
			stateDate.setId(APINikelaoConstants.STATE_DATE_CANCEL);

			date.setStateDate(stateDate);
			
			dateInsert = repository.save(date);
			
			if(dateInsert != null) {
				listDates = new ArrayList<>();
				listDates.add(dateInsert);
				
				apiResponse.setMessage("Se ha cancelado la cita correctamente");
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setResults(listDates);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.OK);
			}else {
				apiResponse.setMessage("No se ha podido cancelar la cita.");
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			log.error(
					"DatesService.addDates(date) - Se ha producido un error al cancelar los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al cancelar los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	

	@Override
	public ResponseEntity<DatesResponseRest> finishDates(Dates date) {
		log.info("DatesService.addDates(date) - Inicio método.");
		ResponseEntity<DatesResponseRest> response = null;
		DatesResponseRest apiResponse = new DatesResponseRest();
		List<Dates> listDates;
		Dates dateInsert;

		try {
			StateDate stateDate = new StateDate();
			stateDate.setId(APINikelaoConstants.STATE_DATE_FINISH);

			date.setStateDate(stateDate);
			
			dateInsert = repository.save(date);
			
			if(dateInsert != null) {
				listDates = new ArrayList<>();
				listDates.add(dateInsert);
				
				apiResponse.setMessage("Se ha cancelado la cita correctamente");
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setResults(listDates);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.OK);
			}else {
				apiResponse.setMessage("No se ha podido cancelar la cita.");
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);

				response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			log.error(
					"DatesService.addDates(date) - Se ha producido un error al cancelar los datos: " + e.getMessage());
			apiResponse.setMessage("Se ha producido un error al cancelar los datos.");
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

			response = new ResponseEntity<DatesResponseRest>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public ResponseEntity<DatesResponseRest> deleteDate(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
