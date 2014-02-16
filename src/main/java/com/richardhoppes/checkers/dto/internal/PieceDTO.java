package com.richardhoppes.checkers.dto.internal;

import com.richardhoppes.checkers.model.value.Color;

import java.util.Date;

public class PieceDTO {

	private Integer currentPosition;
	private Color color;
	private Boolean isKing;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Integer currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Boolean getKing() {
		return isKing;
	}

	public void setKing(Boolean king) {
		isKing = king;
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

	public Integer getXPosition() {
		// TODO: Undo this stupidity
		if (currentPosition >= 1 && currentPosition <= 4) {
			return currentPosition * 2;
		} else if (currentPosition >= 5 && currentPosition <= 8) {
			return ((currentPosition - 4) * 2) - 1;
		} else if (currentPosition >= 9 && currentPosition <= 12) {
			return (currentPosition - 8) * 2;
		} else if (currentPosition >= 13 && currentPosition <= 16) {
			return ((currentPosition - 12) * 2) - 1;
		} else if (currentPosition >= 17 && currentPosition <= 20) {
			return (currentPosition - 16) * 2;
		} else if (currentPosition >= 21 && currentPosition <= 24) {
			return ((currentPosition - 20) * 2) - 1;
		} else if (currentPosition >= 25 && currentPosition <= 28) {
			return (currentPosition - 24) * 2;
		} else if (currentPosition >= 29 && currentPosition <= 32) {
			return ((currentPosition - 28) * 2) - 1;
		}
		return -1;
	}

	public Integer getYPosition() {
		// TODO: Undo this stupidity
		if (currentPosition >= 1 && currentPosition <= 4) {
			return 0;
		} else if (currentPosition >= 5 && currentPosition <= 8) {
			return 1;
		} else if (currentPosition >= 9 && currentPosition <= 12) {
			return 2;
		} else if (currentPosition >= 13 && currentPosition <= 16) {
			return 3;
		} else if (currentPosition >= 17 && currentPosition <= 20) {
			return 4;
		} else if (currentPosition >= 21 && currentPosition <= 24) {
			return 5;
		} else if (currentPosition >= 25 && currentPosition <= 28) {
			return 6;
		} else if (currentPosition >= 29 && currentPosition <= 32) {
			return 7;
		}
		return -1;
	}
}
