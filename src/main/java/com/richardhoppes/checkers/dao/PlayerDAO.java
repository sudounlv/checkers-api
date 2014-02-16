package com.richardhoppes.checkers.dao;

import com.richardhoppes.checkers.dto.internal.GameDTO;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.GamePlayer;
import com.richardhoppes.checkers.model.Player;
import com.richardhoppes.checkers.model.value.Color;
import com.richardhoppes.checkers.model.value.GameResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PlayerDAO extends SqlMapClientDaoSupport{

	private static Logger LOG = LoggerFactory.getLogger(PlayerDAO.class);

	public Player getPlayerById(Integer id) {
		Player player = null;
		try {
			player = (Player) getSqlMapClient().queryForObject("Player.getPlayerById", id);
		} catch (SQLException e){
			LOG.error("Error getting player by id: {}", e);
		}
		return player;
	}

	public Player getPlayerByDeviceId(String deviceId) {
		Player player = null;
		try {
			player = (Player) getSqlMapClient().queryForObject("Player.getPlayerByDeviceId", deviceId);
		} catch (SQLException e){
			LOG.error("Error getting player by device: {}", e);
		}
		return player;
	}

	public GamePlayer getGamePlayerById(Integer id) {
		GamePlayer gamePlayer = null;
		try {
			gamePlayer = (GamePlayer) getSqlMapClient().queryForObject("Player.getGamePlayerById", id);
		} catch (SQLException e){
			LOG.error("Error getting player by id: {}", e);
		}
		return gamePlayer;
	}

	public Player createPlayer(String deviceId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deviceId", deviceId);

		Player player = null;
		try {
			Integer id = (Integer) getSqlMapClient().insert("Player.insertPlayer", params);
			player = getPlayerById(id);
		} catch (SQLException e){
			LOG.error("Error creating game: {}", e);
		}

		return player;
	}

	public GamePlayer createGamePlayer(Integer gameId, Integer playerId, Boolean isCreator, Boolean isTurn, Color color) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gameId", gameId);
		params.put("playerId", playerId);
		params.put("isCreator", isCreator);
		params.put("isTurn", isTurn);
		params.put("color", color);

		GamePlayer gamePlayer = null;
		try {
			Integer id = (Integer) getSqlMapClient().insert("Player.insertGamePlayer", params);
			gamePlayer = getGamePlayerById(id);
		} catch (SQLException e){
			LOG.error("Error creating game: {}", e);
		}

		return gamePlayer;
	}

}
