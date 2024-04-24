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
@Table(name = "nikelao_clients")
@Getter @Setter @NoArgsConstructor
public class Clients implements Serializable{

	private static final long serialVersionUID = 2190630138452686829L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "surname", nullable = true)
	private String surname;
	@Column(name = "address", nullable = true)
	private String address;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name="phone", unique = true, nullable = true)
	private Long phone;
	
	@Column(name="userId", unique = true, nullable = false)
	private Long userId;
	
	@OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Dates> dates;

}
