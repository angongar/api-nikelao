package com.tonigdev.api.nikelao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.repositories.IClientsRepository;
import com.tonigdev.api.nikelao.responses.ClientsResponseRest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientsService implements IClientsService {

	private final IClientsRepository repository;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<ClientsResponseRest> getClients() {
		log.info("ClientsService.getClients() - Se inicia el método.");

		ResponseEntity<ClientsResponseRest> response = null;
		ClientsResponseRest apiResponse = new ClientsResponseRest();

		try {

			List<Clients> listClients = repository.findAll();

			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setMessage("Se han obtenido " + listClients.size() + " resultados.");
			apiResponse.setResults(listClients);

			response = new ResponseEntity<>(apiResponse, HttpStatus.OK);

		} catch (Exception e) {
			log.error("ClientsService.getClients() - Se ha producido un error al realizar la consulta: "
					+ e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un error al realizar la consulta.");

			response = new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<ClientsResponseRest> getClientById(Long id) {
		log.info("ClientsService.getClientById(id=" + id + ") - Se inicia el método.");
		
		ResponseEntity<ClientsResponseRest> response = null;
		ClientsResponseRest apiResponse = new ClientsResponseRest();
		List<Clients> listClients = new ArrayList<>();
		
		Optional<Clients> client = null;
		
		try {
			
			client = repository.findById(id);
			
			if(client.isPresent()) {
				listClients.add(client.get());
				
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setMessage("Se ha encontrado el cliente con el id " + id);
				apiResponse.setResults(listClients);

				response = new ResponseEntity<>(apiResponse, HttpStatus.OK);
			}else {
				apiResponse.setStatus(HttpStatus.NOT_FOUND);
				apiResponse.setMessage("No se ha encontrado el cliente con el id " + id);
				
				response = new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
			}

		}catch(Exception e) {
			log.info("ClientsService.getClientById(id=" + id + ") - Se ha producido un al consultar el cliente con id " + id + ": " + e.getMessage());
			
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un al consultar el cliente con id " + id + ".");

			response = new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return response;
	}
	
	@Override
	public ResponseEntity<ClientsResponseRest> updateClient(Long id, Clients client) {
		log.info("ClientsService.updateClient(id=" + id + ",client=" + client + ") - Se inicia el método.");
		
		ResponseEntity<ClientsResponseRest> response = null;
		ClientsResponseRest apiResponse = new ClientsResponseRest();
		List<Clients> listClients = new ArrayList<>();
		Optional<Clients> clientBD = null;
		Clients clientSave;
		
		try {
			
			if(client != null && id != Long.MIN_VALUE) {

				clientBD = repository.findById(id);
				
				if(clientBD.isPresent()) {
					clientSave = repository.save(client);
					
					listClients.add(clientSave);
					apiResponse.setStatus(HttpStatus.OK);
					apiResponse.setMessage("Se ha actualizado el cliente");
					apiResponse.setResults(listClients);

					response = new ResponseEntity<>(apiResponse, HttpStatus.OK);
				}else {
					apiResponse.setStatus(HttpStatus.NOT_FOUND);
					apiResponse.setMessage("El cliente que desea actualizar, no existe.");

					response = new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
				}
				
			}else {
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				apiResponse.setMessage("No se ha podido actualizar el cliente.");

				response = new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
			}
			
			
			
		}catch(Exception e) {
			log.error("ClientsService.updateClient(id=" + id + ",client=" + client + ") - Se ha producido un error al actualizar el cliente: "
					+ e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un error al actualizar el cliente.");

			response = new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return response;
	}

	@Override
	public ResponseEntity<ClientsResponseRest> addClient(Clients client) {
		log.info("ClientsService.addClient(client=" + client + ") - Se inicia el método.");
		
		ResponseEntity<ClientsResponseRest> response = null;
		ClientsResponseRest apiResponse = new ClientsResponseRest();
		List<Clients> listClients = new ArrayList<>();
		Clients clientBD;
		
		try {
			clientBD = repository.save(client);
			
			listClients.add(clientBD);
			
			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setMessage("Se ha añadido el cliente");
			apiResponse.setResults(listClients);

			response = new ResponseEntity<>(apiResponse, HttpStatus.OK);
			
		}catch(Exception e) {
			log.error("ClientsService.getClients() - Se ha producido un error al añadir el cliente: "
					+ e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			apiResponse.setMessage("Se ha producido un error al añadir el cliente.");

			response = new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return response;
	}

	@Override
	public ResponseEntity<ClientsResponseRest> deleteClient(Long id) {
		log.info("ClientsService.deleteClient(id=" + id + ") - Se inicia el método.");
		
		ResponseEntity<ClientsResponseRest> response = null;
		ClientsResponseRest apiResponse = new ClientsResponseRest();
		
		try {
			
			repository.deleteById(id);
			
			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setMessage("Se ha eliminado el cliente con id " + id + ".");

			response = new ResponseEntity<>(apiResponse, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("ClientsService.deleteClient(id=" + id + ") - Se ha producido un error al eliminar el cliente:" + e.getMessage());
		}
		
		
		return response;
	}

}
