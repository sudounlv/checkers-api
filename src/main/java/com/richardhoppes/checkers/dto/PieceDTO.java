package com.richardhoppes.checkers.dto;

import com.richardhoppes.checkers.model.value.PieceColor;
import org.codehaus.jackson.annotate.JsonProperty;

public class PieceDTO {

	private Boolean isKing;
	private PieceColor pieceColor;
	private LocationDTO location;

	@JsonProperty("king")
	public Boolean getKing() {
		return isKing;
	}

	public void setKing(Boolean king) {
		isKing = king;
	}

	@JsonProperty("team")
	public PieceColor getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	@JsonProperty("location")
	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}
}
