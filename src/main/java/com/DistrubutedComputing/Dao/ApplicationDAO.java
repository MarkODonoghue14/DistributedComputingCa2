package com.DistrubutedComputing.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.DistrubutedComputing.DTO.UserDTO;
import com.DistrubutedComputing.Entity.User;

@Transactional
@Repository
public class ApplicationDAO {
	
	final int POS_OF_USER = 0;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public UserDTO findUser(UserDTO queriedUser) {
		
		UserDTO user = new UserDTO();
		List<User> foundUser = entityManager.createQuery("SELECT e FROM User e WHERE e.username = :username AND e.password = :password", User.class)
				.setParameter("username", queriedUser.getUsername()).setParameter("password", queriedUser.getPassword()).getResultList();		
		if (!foundUser.isEmpty()) {
			user = new UserDTO(foundUser.get(0));
		}		
		return user;
	}
	
	
	public void login(UserDTO user){	
		List<User>foundCustomer =  entityManager.createQuery("Select e from User e where e.username = :username ", User.class)
				.setParameter("username", user.getUsername()).getResultList();
		foundCustomer.get(POS_OF_USER).setLoggedIn(true);
		entityManager.persist(foundCustomer.get(POS_OF_USER));
	}
		
	public void logUserOut(UserDTO userdto) {		
		List<User>foundCustomer =  entityManager.createQuery("Select e from User e where e.username = :username", User.class)
				.setParameter("username", userdto.getUsername()).getResultList();
    foundCustomer.get(POS_OF_USER).setLoggedIn(false);
    entityManager.persist(foundCustomer.get(POS_OF_USER));
	}


}
