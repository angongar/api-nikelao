package com.tonigdev.api.nikelao.responses;

import java.util.List;

import com.tonigdev.api.nikelao.model.Dates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class DatesResponseRest extends APINikelaoResponseRest{
	
	private List<Dates> results;

}
