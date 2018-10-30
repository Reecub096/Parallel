package com.cg.mypaymentapp.service;
import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;


public interface WalletService {
	
		public Customer showBalance (String mobileno);
		public void fundTransfer (String sourceMobileNo,String targetMobileNo, Double amount);
		public Customer depositAmount (String mobileNo,Double amount );
		public Customer withdrawAmount(String mobileNo, Double amount);
		public Customer createAccount(Customer customer);
		
		public boolean validateName(String name) throws InvalidInputException;
		
		public boolean validateMoileNo(String mobileNo) throws InvalidInputException;
		
		public boolean validateAmount(double amount) throws InvalidInputException;

}
