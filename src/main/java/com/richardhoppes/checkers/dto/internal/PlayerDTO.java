package com.richardhoppes.checkers.dto.internal;

import com.richardhoppes.checkers.model.value.Color;

public class PlayerDTO {

	private String deviceId;
	private Boolean isCreator;
	private Boolean isTurn;
	private Color color;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
}
