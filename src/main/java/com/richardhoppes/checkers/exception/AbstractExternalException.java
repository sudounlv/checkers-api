package com.richardhoppes.checkers.exception;

public abstract class AbstractExternalException extends Exception {

	private static final long serialVersionUID = 1L;

	public abstract String getErrorCode();

	public AbstractExternalException(Throwable cause) {
		super(cause);
	}

	public AbstractExternalException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractExternalException(String message) {
		super(message);
	}

	public AbstractExternalException() {
	}
}
