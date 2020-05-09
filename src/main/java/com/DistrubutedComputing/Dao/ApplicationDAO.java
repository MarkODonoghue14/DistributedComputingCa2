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
	
	public  List<UserDTO> login(UserDTO user){
		List <UserDTO> userList = new ArrayList<UserDTO>();		
		List<User>foundCustomer =  entityManager.createQuery("Select e from user e", User.class).getResultList();
		

		
		return userList ;
	}
	
	public void logUserIn(UserDTO userdto) {
		userdto.setLoggedIn(true);
		entityManager.persist(userdto);
	}
	
	public void logUserOut(UserDTO userdto) {
		userdto.setLoggedIn(false);
		entityManager.persist(userdto);
	}


}
