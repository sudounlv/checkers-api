package com.richardhoppes.checkers.exception;

public class ResourceNotFoundException extends AbstractExternalException {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_CODE = "resource_not_found";

	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException() {
	}
}
