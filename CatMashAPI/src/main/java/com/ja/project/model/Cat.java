package com.ja.project.model;

import java.time.Instant;
import java.util.Objects;

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
@Table(name = "cats")
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "picture", columnDefinition = "varchar(512) not null")
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

	
	//CONSTRUCTORS
	
	public Cat() {
		super();
	}
	
	public Cat(String picture, String jsonId) {
		super();
		this.picture = picture;
		this.jsonId = jsonId;
		this.popularity = 0;
	}
	
	//METHODS
	
	public void vote() {
		this.popularity++;
	}


	//GETTERS & SETTERS
	
	public int getId() {
		return id;
	}

	public String getPicture() {
		return picture;
	}

	public String getJsonId() {
		return jsonId;
	}

	public int getPopularity() {
		return popularity;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	//EQUALS & HASHCODE
	
	@Override
	public int hashCode() {
		return Objects.hash(id, jsonId, picture);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return id == other.id && Objects.equals(jsonId, other.jsonId) && Objects.equals(picture, other.picture);
	}
	
}
