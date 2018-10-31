package com.cg.mypaymentapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mypaymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo{
	
	//Map<String, Customer> customerMap;
	EntityManager manager;
	
	public WalletRepoImpl() {
		// TODO Auto-generated constructor stub
		//customerMap = DataStore.createCollection();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		manager = emf.createEntityManager();
		
	}
	
	@Override
	public Customer showBalance(String mobileno) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		Query query = manager.createQuery("SELECT p.name, p.mobile, p.amount FROM Customer p where mobile = :mobdata");
		query.setParameter("mobdata", mobileno);
		Customer customer = (Customer) query.getSingleResult();
		manager.getTransaction().commit();
		return customer;
	}
	
	@Override
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, Double amount) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		Query sourceQuery = manager.createQuery("UPDATE Customer SET amount = :sourcebal where mobile = :sourcemobile");
		sourceQuery.setParameter("sourcebal", amount);
		sourceQuery.setParameter("sourcemobile", sourceMobileNo);
		manager.getTransaction().commit();
		
	}
	
	@Override
	public Customer depositAmount(String mobileNo, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Customer withdrawAmount(String mobileNo, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Customer createAccount(Customer customer) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();
		return customer;
	}

}
