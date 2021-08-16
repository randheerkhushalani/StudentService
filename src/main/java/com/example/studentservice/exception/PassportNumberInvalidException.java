package com.example.studentservice.exception;

public class PassportNumberInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1615119236906423787L;

	public PassportNumberInvalidException(String exception) {
		super(exception);
	}

}