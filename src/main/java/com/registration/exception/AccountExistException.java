package com.registration.exception;

public class AccountExistException extends Exception {
	private static final long serialVersionUID =1L;
	public AccountExistException(String errorMessage) {
		super(errorMessage);
	}
	public AccountExistException(String errorMessage, Exception e){
		super(errorMessage, e);
	}
}
