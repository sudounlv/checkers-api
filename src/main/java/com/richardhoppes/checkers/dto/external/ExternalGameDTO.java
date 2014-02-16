package com.richardhoppes.checkers.dto.external;

import com.richardhoppes.checkers.model.value.Color;
import org.codehaus.jackson.annotate.JsonProperty;

public class ExternalGameDTO {

	private String id;
	private Color turn;
	private ExternalBoardDTO board;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("turn")
	public Color getTurn() {
		return turn;
	}

	public void setTurn(Color turn) {
		this.turn = turn;
	}

	@JsonProperty("board")
	public ExternalBoardDTO getBoard() {
		return board;
	}

	public void setBoard(ExternalBoardDTO board) {
		this.board = board;
	}

}
