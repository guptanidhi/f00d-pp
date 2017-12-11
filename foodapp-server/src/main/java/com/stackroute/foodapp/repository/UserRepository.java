package com.stackroute.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.foodapp.model.Restaurant;

public interface UserRepository extends JpaRepository<Restaurant, Integer> {
	public Restaurant findByName(String name);
}
