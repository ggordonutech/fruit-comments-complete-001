package com.fruitcomments.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Entity
@Table(name="fruits")
public class Fruit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column 
	private String description;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	
	@JsonIgnoreProperties("fruit")
	@LazyCollection(value = LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="fruit")
	private List<Comment> comments;
	
	public Fruit() {
		super();
	}
	
	public Fruit(int id, String name, String description, String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoUrl = photoUrl;
	}
	
	
	public Fruit(int id, String name, String description, String photoUrl, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoUrl = photoUrl;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	
	

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", description=" + description + ", photoUrl=" + photoUrl + "]";
	}
	
	
	
	
	

}
