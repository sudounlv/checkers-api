package com.richardhoppes.checkers.exception;

import com.richardhoppes.checkers.exception.AbstractExternalException;

public class GameJoinException extends AbstractExternalException {

	private static final long serialVersionUID = 1L;

	private static final String ERROR_CODE = "join_game_exception";

	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

	public GameJoinException(Throwable cause) {
		super(cause);
	}

	public GameJoinException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameJoinException(String message) {
		super(message);
	}

	public GameJoinException() {
	}
}
