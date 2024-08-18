package com.luv2code.restcrud.exception;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public StudentNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
