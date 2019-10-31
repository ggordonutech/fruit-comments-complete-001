package com.fruitcomments.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column private String comment;
	@Column  private String author;
	@Column  private int rating;
	@ManyToOne private Fruit fruit;
	
	
	
	public Comment() {
		super();
	}



	public Comment(int id, String comment, String author, int rating) {
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.rating = rating;
	}



	public Comment(int id, String comment, String author, int rating, Fruit fruit) {
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.rating = rating;
		this.fruit = fruit;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public Fruit getFruit() {
		return fruit;
	}



	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}



	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", author=" + author + ", rating=" + rating + "]";
	}
	
	
	
	

}
