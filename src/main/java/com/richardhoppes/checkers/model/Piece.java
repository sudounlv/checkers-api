package com.richardhoppes.checkers.model;

import com.richardhoppes.checkers.model.value.PieceColor;
import com.richardhoppes.checkers.model.value.PieceStatus;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties({ "gameId", "createdAt", "modifiedAt" })
public class Piece {

	private Integer id;
	private Integer gameId;
	private PieceColor color;
	private PieceStatus status;
	private Integer currentPosition;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	@JsonProperty("color")
	public PieceColor getColor() {
		return color;
	}

	public void setColor(PieceColor color) {
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

	@JsonProperty("status")
	public PieceStatus getStatus() {
		return status;
	}

	public void setStatus(PieceStatus status) {
		this.status = status;
	}

	@JsonProperty("position")
	public Integer getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Integer currentPosition) {
		this.currentPosition = currentPosition;
	}
}
