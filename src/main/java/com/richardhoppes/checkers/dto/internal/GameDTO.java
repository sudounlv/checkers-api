package com.richardhoppes.checkers.dto.internal;

import com.richardhoppes.checkers.model.value.Color;
import com.richardhoppes.checkers.model.value.GameResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameDTO {

	private Integer id;
	private String guid;
	private GameResult result;
	private Date createdAt;
	private Date modifiedAt;
	private List<PlayerDTO> players = new ArrayList<PlayerDTO>();
	private List<PieceDTO> pieces = new ArrayList<PieceDTO>();

	public GameResult getResult() {
		return result;
	}

	public void setResult(GameResult result) {
		this.result = result;
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

	public List<PieceDTO> getPieces() {
		return pieces;
	}

	public void setPieces(List<PieceDTO> pieces) {
		this.pieces = pieces;
	}

	public Color getTurn() {
		Color theGuy = null;
		for (PlayerDTO player : players) {
			if (player.getTurn()) {
				theGuy = player.getColor();
				break;
			}
		}
		return theGuy;
	}

	public Color getAvailableColor() {
		Color availableColor = null;
		if (getCanJoin()) {
			if(players.get(0).getColor() == Color.BLACK)
				availableColor = Color.RED;
			else
				availableColor = Color.BLACK;
		}
		return availableColor;
	}

	public Boolean getCanJoin() {
		return (players.size() == 1);
	}

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

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}
}
