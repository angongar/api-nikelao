package com.tonigdev.api.nikelao.model;

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
import lombok.Setter;

@Entity
@Table(name = "nikelao_horary")
@Getter @Setter @NoArgsConstructor
public class Horary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hour", nullable = false)
	private String hour;
	
	@OneToMany(mappedBy = "horary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore // Evita la serialización de este campo para evitar bucles infinitos
	private Set<Dates> dates;
	
	
}
