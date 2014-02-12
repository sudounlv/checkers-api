package com.richardhoppes.checkers.dto;

import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.Piece;

import java.util.Map;

public class GameDTO {

	private Game game;
	private Map<Integer, Piece> board;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Map<Integer, Piece> getBoard() {
		return board;
	}

	public void setBoard(Map<Integer, Piece> board) {
		this.board = board;
	}
}
