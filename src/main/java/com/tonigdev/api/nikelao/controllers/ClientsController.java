package com.tonigdev.api.nikelao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.responses.ClientsResponseRest;
import com.tonigdev.api.nikelao.services.IClientsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-nikelao")
@RequiredArgsConstructor
public class ClientsController {
	
	private final IClientsService service;	
	
	@GetMapping("/clients")
	public ResponseEntity<ClientsResponseRest> getClients(){
		return service.getClients();
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientsResponseRest> getClientById(@PathVariable Long id){
		return service.getClientById(id);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<ClientsResponseRest> addClient(@RequestBody Clients client){
		return service.addClient(client);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<ClientsResponseRest> updateClient(@PathVariable Long id, @RequestBody Clients client){
		return service.updateClient(id, client);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<ClientsResponseRest> deleteClient(@PathVariable Long id){
		return service.deleteClient(id);
	}

}
