package com.stackroute.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.stackroute.foodapp.exceptions.DuplicateUserFoundException;
import com.stackroute.foodapp.exceptions.UserNotFoundException;
import com.stackroute.foodapp.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean saveUser(User user) throws DuplicateUserFoundException {

		if (entityManager.find(User.class, user.getUserId()) != null) {
			throw new DuplicateUserFoundException("User Registration failed, User already exists");
		}
		entityManager.persist(user);
		return true;
	}

	public boolean updateUser(User user) throws UserNotFoundException {
		User user1 = entityManager.find(User.class, user.getUserId());
		if (user1 == null) {
			throw new UserNotFoundException("Couldn't update user. user not found!");
		}
		entityManager.merge(user);
		return true;
	}

	public boolean deleteUser(String userId) throws UserNotFoundException {
		User user = entityManager.find(User.class, userId);
		if (user == null) {
			throw new UserNotFoundException("Could not delete , user not found!");
		}
		entityManager.remove(user);
		return true;
	}

	public User getUserById(String userId) throws UserNotFoundException {
		User user = entityManager.find(User.class, userId);
		if (user == null) {
			throw new UserNotFoundException("user not found!");
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return entityManager.createQuery("From User").getResultList();
	}

}
