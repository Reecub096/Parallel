package com.cg.mypaymentapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService{
	
		WalletRepo wallet;
		Map<String, Customer> walletMap;
	
		public WalletServiceImpl() {
				// TODO Auto-generated constructor stub
				wallet = new WalletRepoImpl();
				walletMap = new HashMap<>();
		}

		@Override
		public Customer showBalance(String mobileno)  throws InvalidInputException{
				// TODO Auto-generated method stub
				Customer cust = walletMap.get(mobileno);
				System.out.println("Mobile no: " + cust.getMobileNo());
				System.out.println("Name : " + cust.getName());
				System.out.println("Balance : " + cust.getAmount());
				return cust;
		}

		@Override
		public void fundTransfer(String sourceMobileNo, String targetMobileNo,Double amount) throws InvalidInputException{
				// TODO Auto-generated method stub
				Customer source = walletMap.get(sourceMobileNo);
				Customer target = walletMap.get(targetMobileNo);
				if (amount > 0) {
						if((source.getAmount() - amount) >= 0)
						{	
								double bal1 = target.getAmount();
								bal1 += amount;
								target.setAmount(bal1);
								walletMap.put(targetMobileNo, target);
								double bal2 = source.getAmount();
								bal2 -= amount;
								source.setAmount(bal2);
								walletMap.put(sourceMobileNo, source);
						}
						else {
								throw new InsufficientBalanceException("Balance should be higher than amount to be transferred !!!! ");
						}
				}
				else 
						throw new InvalidInputException("Amount should be positive to send");
		}


		@Override
		public Customer withdrawAmount(String mobileNo, Double amount) throws InvalidInputException {
				// TODO Auto-generated method stub
				Customer customer = walletMap.get(mobileNo);
				if(amount > 0) {
						if((customer.getAmount() - amount) >= 0)
						{
								customer.setAmount(customer.getAmount() - amount);
								System.out.println(amount + " Withdrawn \n Balance : " + customer.getAmount());
								return customer;
						}
						else 
								throw new InsufficientBalanceException("Balance is not sufficient for this withdrawl amount");
				}
				else 
						throw new InvalidInputException("Amount cannot be Negative ");
		}

		@Override
		public Customer depositAmount(String mobileNo, Double amount)throws InvalidInputException {
				// TODO Auto-generated method stub
				Customer customer = walletMap.get(mobileNo);
				if (amount > 0) {
						double bal = customer.getAmount();
						bal += amount;
						customer.setAmount(bal);
						System.out.println(amount + " Deposited \n Balance : " + customer.getAmount());
						return customer;
				}
				else 
						throw new InvalidInputException("Amount should be positive");
		}

		@Override
		public Customer createAccount(Customer customer) throws InvalidInputException{
			// TODO Auto-generated method stub
			walletMap.put(customer.getMobileNo(), customer);
			return customer;
		}
		
		@Override
		public boolean validateName(String name) throws InvalidInputException {
			// TODO Auto-generated method stub
			if(name == null)
				throw new InvalidInputException("Null value found");
			Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,10}");
			Matcher m = p.matcher(name); 
			if(!m.matches())
				System.out.println("Name invalid!(Should Start with Capital letter and minimum length should be 3....)");
			return m.matches();
			
		}

		@Override
		public boolean validateMoileNo(String mobileNo) throws InvalidInputException{
			try{
				// TODO Auto-generated method stub
				if(mobileNo == null)
					throw new InvalidInputException("Null value found");
				Pattern p = Pattern.compile("[6789][0-9]{9}");
				Matcher m = p.matcher(mobileNo);
				if(!m.matches())
					System.out.println("Mobile Number Invalid! (Should start  with 6 - 9 and length should be 10.....");
				return m.matches();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
			return false;
		}

		@Override
		public boolean validateAmount(double amount) throws InvalidInputException {
			// TODO Auto-generated method stub
			try{
				if(amount == 0)
					throw new InvalidInputException("Null value found");
				String am = String.valueOf(amount);
				if(!am.matches("\\d{1,9}\\.\\d{0,4}"))
					System.out.println("Invalid Amount!(Should be greater than 0)");
				else
					return (am.matches("\\d{1,9}\\.\\d{0,4}"));
			}
			catch(InvalidInputException e){
				System.out.println(e);
				
			}
			return false;
		}
	
}
