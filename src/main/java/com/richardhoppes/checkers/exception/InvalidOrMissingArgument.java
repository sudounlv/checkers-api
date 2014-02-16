package com.richardhoppes.checkers.exception;

public class InvalidOrMissingArgument extends AbstractExternalException {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_CODE = "invalid_or_missing_argument";

	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

	public InvalidOrMissingArgument(Throwable cause) {
		super(cause);
	}

	public InvalidOrMissingArgument(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOrMissingArgument(String message) {
		super(message);
	}

	public InvalidOrMissingArgument() {
	}
}
