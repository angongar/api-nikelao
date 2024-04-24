package com.tonigdev.api.nikelao.responses;

import java.util.List;

import com.tonigdev.api.nikelao.model.Horary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class HoraryResponseRest extends APINikelaoResponseRest{
	
	private List<Horary> results;

}
