package com.tonigdev.api.nikelao.services;

import org.springframework.http.ResponseEntity;

import com.tonigdev.api.nikelao.model.Clients;
import com.tonigdev.api.nikelao.responses.APINikelaoResponseRest;
import com.tonigdev.api.nikelao.responses.ClientsResponseRest;

public interface IClientsService {
	
	public ResponseEntity<ClientsResponseRest> getClients();
	
	public ResponseEntity<ClientsResponseRest> getClientById(Long id);
	
	public ResponseEntity<ClientsResponseRest> updateClient(Long id, Clients client);
	
	public ResponseEntity<ClientsResponseRest> addClient(Clients client);
	
	public ResponseEntity<ClientsResponseRest> deleteClient(Long id);

}
