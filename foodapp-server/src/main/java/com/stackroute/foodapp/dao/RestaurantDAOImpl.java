package com.stackroute.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.stackroute.foodapp.exceptions.DuplicateRestaurantFoundException;
import com.stackroute.foodapp.exceptions.RestaurantNotFoundException;
import com.stackroute.foodapp.model.Restaurant;

@Repository
@Transactional
public class RestaurantDAOImpl implements RestaurantDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean addRestaurant(Restaurant restaurant) throws DuplicateRestaurantFoundException {
		if (entityManager.find(Restaurant.class, restaurant.getId()) != null) {
			throw new DuplicateRestaurantFoundException("Adding restaurant failed, Restaurant already exists");
		}
		entityManager.persist(restaurant);
		return true;
	}

	public boolean updateRestaurant(String id, String comments) throws RestaurantNotFoundException {
		Restaurant restaurant = entityManager.find(Restaurant.class, id);
		if (restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant doesnot exists");
		}
		restaurant.setComments(comments);
		entityManager.merge(restaurant);
		return true;
	}

	public boolean deleteRestaurant(String id) throws RestaurantNotFoundException {
		Restaurant restaurant = entityManager.find(Restaurant.class, id);
		if (restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant doesnot exists");
		}
		entityManager.remove(restaurant);
		return true;
	}

	public Restaurant getRestaurant(String id) throws RestaurantNotFoundException {
		Restaurant restaurant = entityManager.find(Restaurant.class, id);
		if (restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant doesnot exists");
		}
		return restaurant;
	}

	public Restaurant getRestaurantByName(String name) throws RestaurantNotFoundException {
		Restaurant restaurant = (Restaurant) entityManager.createQuery("from Restaurant where name = ?")
				.setParameter(1, name).getSingleResult();
		if (restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant doesnot exists");
		}
		return restaurant;
	}

	@SuppressWarnings("unchecked")
	public List<Restaurant> getAllRestaurant() throws RestaurantNotFoundException {
		return entityManager.createQuery("from Restaurant").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Restaurant> getMyRestaurant(String userId) throws RestaurantNotFoundException {
		return entityManager.createQuery("From Restaurant where userId=?").setParameter(1, userId).getResultList();
	}

}
