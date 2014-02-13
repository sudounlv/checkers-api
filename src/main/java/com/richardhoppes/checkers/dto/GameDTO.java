package com.richardhoppes.checkers.dto;

import com.richardhoppes.checkers.model.value.PieceColor;
import org.codehaus.jackson.annotate.JsonProperty;

public class GameDTO {

	private String id;
	private PieceColor turn;
	private BoardDTO board;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("turn")
	public PieceColor getTurn() {
		return turn;
	}

	public void setTurn(PieceColor turn) {
		this.turn = turn;
	}

	@JsonProperty("board")
	public BoardDTO getBoard() {
		return board;
	}

	public void setBoard(BoardDTO board) {
		this.board = board;
	}

}
