package com.richardhoppes.checkers.exception;

public class PropertyNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PropertyNotFoundException(Throwable cause) {
		super(cause);
	}

	public PropertyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyNotFoundException(String message) {
		super(message);
	}

	public PropertyNotFoundException() {
	}
}
