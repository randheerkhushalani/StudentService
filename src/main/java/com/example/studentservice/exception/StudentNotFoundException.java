package com.example.studentservice.exception;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1615119236906423787L;

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}