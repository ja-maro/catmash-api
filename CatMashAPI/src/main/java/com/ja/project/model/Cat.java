package com.ja.project.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cat")
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "picture", columnDefinition = "varchar(255) not null")
	private String picture;
	
	@Column(name = "json_id", columnDefinition = "varchar(12) not null unique")
	private String jsonId;
	
	@Column(name = "popularity", columnDefinition = "integer default 0")
	private int popularity;

	@JsonIgnore
	@CreationTimestamp
	@Column(name = "creation_date", columnDefinition = "datetime")
	private Instant creationDate;

	@JsonIgnore
	@UpdateTimestamp
	@Column(name = "updated_date", columnDefinition = "datetime")
	private Instant updatedDate;
	
}
