package com.cg.mypaymentapp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Column(name = "cust_name")
	private String name;
	
	@Id
	@Column(name = "cust_mobno")
	private String mobileNo;
	
	@Column(name = "balance")
	private Double amount;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

		
	public Customer(String name, String mobileNo, Double amount) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.amount = amount;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNo=" + mobileNo
				+ ", amount=" + amount + "]";
	}
		
		
}


