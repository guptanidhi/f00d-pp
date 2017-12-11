package com.stackroute.foodapp.dao;

import java.util.List;

import com.stackroute.foodapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodapp.model.Restaurant;

public interface RestaurantDAO {

	public boolean addRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException;

	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException;

	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurant(String id) throws RestaurantNotFoundException;

	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException;

	public List<Restaurant> getAllRestaurant() throws RestaurantNotFoundException;

	public List<Restaurant> getMyRestaurant(String userId) throws RestaurantNotFoundException;

}
