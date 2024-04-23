package com.tonigdev.api.nikelao.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news")
@Getter @Setter @NoArgsConstructor
public class News implements Serializable{

	private static final long serialVersionUID = -5833546340803181176L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "date", nullable = false)
	private String date;
	@Column(name = "content", nullable = false)
	private String content;
	

}
