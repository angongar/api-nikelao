package com.tonigdev.api.nikelao.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nikelao_state_date")
@Getter @Setter @NoArgsConstructor
public class StateDate implements Serializable{

	private static final long serialVersionUID = 1993285011329611971L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "state_name", unique = true, nullable = false)
	private String stateName;
	
	@OneToMany(mappedBy = "stateDate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore // Evita la serialización de este campo para evitar bucles infinitos
	private Set<Dates> dates;
	

}
