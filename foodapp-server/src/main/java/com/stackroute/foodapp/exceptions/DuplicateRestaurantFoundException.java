package com.stackroute.foodapp.exceptions;

@SuppressWarnings("serial")
public class DuplicateRestaurantFoundException extends Exception {

	public DuplicateRestaurantFoundException(String message) {
		super(message);
	}
}
