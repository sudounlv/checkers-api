package com.richardhoppes.checkers.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {

	private Integer spacesPerSide;
	private List<PieceDTO> pieces = new ArrayList<PieceDTO>();

	@JsonProperty("spacesPerSide")
	public Integer getSpacesPerSide() {
		return spacesPerSide;
	}

	public void setSpacesPerSide(Integer spacesPerSide) {
		this.spacesPerSide = spacesPerSide;
	}

	@JsonProperty("pieces")
	public List<PieceDTO> getPieces() {
		return pieces;
	}

	public void setPieces(List<PieceDTO> pieces) {
		this.pieces = pieces;
	}

}
