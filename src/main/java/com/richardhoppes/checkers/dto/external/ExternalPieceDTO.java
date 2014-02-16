package com.richardhoppes.checkers.dto.external;

import com.richardhoppes.checkers.model.value.Color;
import org.codehaus.jackson.annotate.JsonProperty;

public class ExternalPieceDTO {

	private Boolean isKing;
	private Color pieceColor;
	private ExternalLocationDTO location;

	@JsonProperty("king")
	public Boolean getKing() {
		return isKing;
	}

	public void setKing(Boolean king) {
		isKing = king;
	}

	@JsonProperty("team")
	public Color getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(Color pieceColor) {
		this.pieceColor = pieceColor;
	}

	@JsonProperty("location")
	public ExternalLocationDTO getLocation() {
		return location;
	}

	public void setLocation(ExternalLocationDTO location) {
		this.location = location;
	}
}
