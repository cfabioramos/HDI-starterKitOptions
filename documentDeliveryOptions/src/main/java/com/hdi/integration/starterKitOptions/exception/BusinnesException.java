package com.hdi.integration.starterKitOptions.exception;

public class BusinnesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public BusinnesException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
