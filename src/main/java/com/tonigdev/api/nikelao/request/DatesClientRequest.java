package com.tonigdev.api.nikelao.request;

import java.io.Serializable;

import com.tonigdev.api.nikelao.model.Horary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class DatesClientRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7688140931615853414L;
	private Long clientId;
	private Horary horary;
	private String date;
	private Long stateDateId;

}
