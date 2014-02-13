package com.richardhoppes.checkers.model;

import com.richardhoppes.checkers.model.value.GameWinner;
import com.richardhoppes.checkers.model.value.GameStatus;
import com.richardhoppes.checkers.model.value.PieceColor;

import java.util.Date;

public class Game {
	private Integer id;
	private String guid;
	private PieceColor turn;
	private GameWinner winner;
	private GameStatus status;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public GameWinner getWinner() {
		return winner;
	}

	public void setWinner(GameWinner winner) {
		this.winner = winner;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public PieceColor getTurn() {
		return turn;
	}

	public void setTurn(PieceColor turn) {
		this.turn = turn;
	}
}
