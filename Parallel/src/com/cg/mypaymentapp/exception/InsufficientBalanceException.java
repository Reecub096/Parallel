package com.cg.mypaymentapp.exception;

public class InsufficientBalanceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8671436944182184872L;

	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
