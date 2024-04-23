package com.tonigdev.api.nikelao.responses;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class APINikelaoResponseRest {
	
	private HttpStatus status;
	private String message;
	
	

}
