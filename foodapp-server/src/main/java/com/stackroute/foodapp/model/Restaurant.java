package com.stackroute.foodapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Restaurant {

	@Id
	@ApiModelProperty(notes = "The database generated product ID")
	private String id;

	@ApiModelProperty(notes = "The database generated product ID")
	private String name;

	@ApiModelProperty(notes = "The database generated product ID")
	private String address;

	@ApiModelProperty(notes = "The database generated product ID")
	private String featuredImage;

	@ApiModelProperty(notes = "The database generated product ID")
	private String cuisines;

	@ApiModelProperty(notes = "The database generated product ID")
	private String averageCostForTwo;

	@ApiModelProperty(notes = "The database generated product ID")
	private String rating;

	@ApiModelProperty(notes = "The database generated product ID")
	private String comments;

	@ApiModelProperty(notes = "The database generated product ID")
	private String city;

	@ApiModelProperty(notes = "The database generated product ID")
	private String userId;

	@ManyToOne
	@JoinColumn(name = "userId", updatable = false, insertable = false)
	private User user;

	public Restaurant() {

	}

	public Restaurant(String id, String name, String address, String featuredImage, String cuisines,
			String averageCostForTwo, String rating, String comments, String city, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.featuredImage = featuredImage;
		this.cuisines = cuisines;
		this.averageCostForTwo = averageCostForTwo;
		this.rating = rating;
		this.comments = comments;
		this.city = city;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getCuisines() {
		return cuisines;
	}

	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}

	public String getAverageCostForTwo() {
		return averageCostForTwo;
	}

	public void setAverageCostForTwo(String averageCostForTwo) {
		this.averageCostForTwo = averageCostForTwo;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
