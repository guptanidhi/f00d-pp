package com.stackroute.foodapp.service;

import java.util.List;

import com.stackroute.foodapp.exceptions.DuplicateUserFoundException;
import com.stackroute.foodapp.exceptions.UserNotFoundException;
import com.stackroute.foodapp.model.User;

public interface UserService {

	public boolean saveUser(User user) throws DuplicateUserFoundException;

	public boolean updateUser(User user) throws UserNotFoundException;

	public boolean deleteUser(String userId) throws UserNotFoundException;

	public User getUserById(String userId) throws UserNotFoundException;

	public List<User> getAllUsers();
}
