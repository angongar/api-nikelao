package com.tonigdev.api.nikelao.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="nikelao_dates")
@Getter @Setter @NoArgsConstructor
public class Dates implements Serializable{

	private static final long serialVersionUID = 4523112647136391108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@Column(name = "rating", nullable = true)
	private Long rating;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	@JsonIgnore // Evita la serialización de este campo para evitar bucles infinitos
	private Clients client;
	
	@ManyToOne
	@JoinColumn(name = "state_date_id", nullable = false)
	private StateDate stateDate;
	
	
	@ManyToOne
	@JoinColumn(name = "horary_id", nullable = false)
	private Horary horary;
}
