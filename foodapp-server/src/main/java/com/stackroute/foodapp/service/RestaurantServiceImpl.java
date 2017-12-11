package com.stackroute.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodapp.dao.RestaurantDAO;
import com.stackroute.foodapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodapp.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	public boolean addNewRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException {
		return restaurantDAO.addRestaurant(restaurant);
	}

	@Override
	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException {
		return restaurantDAO.updateRestaurant(id, comments);
	}

	@Override
	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException {
		return restaurantDAO.deleteRestaurant(id);
	}

	@Override
	public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
		return restaurantDAO.getRestaurant(id);
	}

	@Override
	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException {
		return restaurantDAO.getRestaurantByName(name);
	}

	@Override
	public List<Restaurant> getAllRestaurants() throws RestaurantNotFoundException {
		return restaurantDAO.getAllRestaurant();
	}

	@Override
	public List<Restaurant> getMyRestaurants(String userId) throws RestaurantNotFoundException {
		return restaurantDAO.getMyRestaurant(userId);
	}

}
