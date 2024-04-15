package com.tonigdev.api.nikelao.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nikelao_state_date")
@Getter @Setter @RequiredArgsConstructor
public class StateDate implements Serializable{

	private static final long serialVersionUID = 1993285011329611971L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "state_name", unique = true, nullable = false)
	private String stateName;
	
	@OneToMany(mappedBy = "stateDate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Dates> dates;
	

}
