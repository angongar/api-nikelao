package com.tonigdev.api.nikelao.request;

import java.io.Serializable;

import com.tonigdev.api.nikelao.model.Dates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class DatesRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7688140931615853414L;
	private Dates date;

}
