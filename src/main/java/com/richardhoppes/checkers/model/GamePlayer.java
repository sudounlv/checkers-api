package com.richardhoppes.checkers.model;

import com.richardhoppes.checkers.model.value.Color;

import java.util.Date;

public class GamePlayer {

	private Integer id;
	private Integer playerId;
	private Integer gameId;
	private Boolean isCreator;
	private Boolean isTurn;
	private Color color;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Boolean getCreator() {
		return isCreator;
	}

	public void setCreator(Boolean creator) {
		isCreator = creator;
	}

	public Boolean getTurn() {
		return isTurn;
	}

	public void setTurn(Boolean turn) {
		isTurn = turn;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
}
