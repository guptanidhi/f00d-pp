package com.stackroute.foodapp.exceptions;

@SuppressWarnings("serial")
public class RestaurantNotFoundException extends Exception {
	
	public RestaurantNotFoundException(String message) {
		super(message);
	}
}
