package com.tonigdev.api.nikelao.responses;

import java.util.List;

import com.tonigdev.api.nikelao.model.Clients;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class ClientsResponseRest extends APINikelaoResponseRest{
	
	private List<Clients> results;

}
