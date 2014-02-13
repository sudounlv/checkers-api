package com.richardhoppes.checkers.dto;

import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.Piece;

import java.util.List;

public class GameDTO {

	private Game game;
	private List<Piece> pieces;

	public GameDTO(Game game, List<Piece> pieces) {
		this.game = game;
		this.pieces = pieces;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

}
