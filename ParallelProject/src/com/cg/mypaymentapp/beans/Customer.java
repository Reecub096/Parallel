package com.cg.mypaymentapp.beans;



public class Customer {

		private String name;
		private String mobileNo;
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


