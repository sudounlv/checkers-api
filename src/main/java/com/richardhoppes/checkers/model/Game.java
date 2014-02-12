package com.richardhoppes.checkers.model;

import com.richardhoppes.checkers.model.value.GameResult;
import com.richardhoppes.checkers.model.value.GameStatus;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class Game {
	private Integer id;
	private String guid;
	private GameResult result;
	private GameStatus status;
	private Date createdAt;
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("id")
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@JsonProperty("result")
	public GameResult getResult() {
		return result;
	}

	public void setResult(GameResult result) {
		this.result = result;
	}

	@JsonProperty("status")
	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	@JsonProperty("createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("modifiedAt")
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
