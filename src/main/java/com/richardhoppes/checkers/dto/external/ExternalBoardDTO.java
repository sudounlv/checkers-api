package com.richardhoppes.checkers.dto.external;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ExternalBoardDTO {

	private Integer spacesPerSide;
	private List<ExternalPieceDTO> pieces = new ArrayList<ExternalPieceDTO>();

	@JsonProperty("spacesPerSide")
	public Integer getSpacesPerSide() {
		return spacesPerSide;
	}

	public void setSpacesPerSide(Integer spacesPerSide) {
		this.spacesPerSide = spacesPerSide;
	}

	@JsonProperty("pieces")
	public List<ExternalPieceDTO> getPieces() {
		return pieces;
	}

	public void setPieces(List<ExternalPieceDTO> pieces) {
		this.pieces = pieces;
	}

}
