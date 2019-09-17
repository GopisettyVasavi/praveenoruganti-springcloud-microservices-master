package com.praveen.jpa.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;	
	
	private String rating;

	protected Review() {
		
	}
	public Review(String description,String rating){
		this.description=description;
		this.rating=rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Review[%s %s]", description,rating);
	}
	
}
