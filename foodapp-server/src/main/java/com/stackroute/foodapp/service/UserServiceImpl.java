package com.stackroute.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.foodapp.dao.UserDAO;
import com.stackroute.foodapp.exceptions.DuplicateUserFoundException;
import com.stackroute.foodapp.exceptions.UserNotFoundException;
import com.stackroute.foodapp.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean saveUser(User user) throws DuplicateUserFoundException {
		return userDAO.saveUser(user);
	}

	public boolean updateUser(User user) throws UserNotFoundException {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		return userDAO.getUserById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
