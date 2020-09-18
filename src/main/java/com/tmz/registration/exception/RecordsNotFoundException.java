package com.tmz.registration.exception;


public class RecordsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String message;

	public RecordsNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
