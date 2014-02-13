package com.richardhoppes.checkers.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({"position"})
public class LocationDTO {

	private Integer position;

	@JsonProperty("x")
	public Integer getX() {
		// TODO: Undo this stupidity
		if (position >= 1 && position <= 4) {
			return position * 2;
		} else if (position >= 5 && position <= 8) {
			return ((position - 4) * 2) - 1;
		} else if (position >= 9 && position <= 12) {
			return (position - 8) * 2;
		} else if (position >= 13 && position <= 16) {
			return ((position - 12) * 2) - 1;
		} else if (position >= 17 && position <= 20) {
			return (position - 16) * 2;
		} else if (position >= 21 && position <= 24) {
			return ((position - 20) * 2) - 1;
		} else if (position >= 25 && position <= 28) {
			return (position - 24) * 2;
		} else if (position >= 29 && position <= 32) {
			return ((position - 28) * 2) - 1;
		}
		return -1;
	}

	@JsonProperty("y")
	public Integer getY() {
		// TODO: Undo this stupidity
		if (position >= 1 && position <= 4) {
			return 0;
		} else if (position >= 5 && position <= 8) {
			return 1;
		} else if (position >= 9 && position <= 12) {
			return 2;
		} else if (position >= 13 && position <= 16) {
			return 3;
		} else if (position >= 17 && position <= 20) {
			return 4;
		} else if (position >= 21 && position <= 24) {
			return 5;
		} else if (position >= 25 && position <= 28) {
			return 6;
		} else if (position >= 29 && position <= 32) {
			return 7;
		}
		return -1;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
}
