package com.cg.mypaymentapp.repo;

import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.DataStore;

public class WalletRepoImpl implements WalletRepo{
	
	Map<String, Customer> customerMap;
	
	public WalletRepoImpl() {
		// TODO Auto-generated constructor stub
		customerMap = DataStore.createCollection();
	}
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
