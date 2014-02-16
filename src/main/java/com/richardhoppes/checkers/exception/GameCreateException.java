package com.richardhoppes.checkers.exception;

public class GameCreateException extends AbstractExternalException {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_CODE = "join_game_exception";

	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

	public GameCreateException(Throwable cause) {
		super(cause);
	}

	public GameCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameCreateException(String message) {
		super(message);
	}

	public GameCreateException() {
	}
}
