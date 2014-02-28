package com.richardhoppes.checkers.dao;

import com.richardhoppes.checkers.dto.internal.GameDTO;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.value.Color;
import com.richardhoppes.checkers.model.value.GameResult;
import com.richardhoppes.checkers.model.value.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GameDAO extends SqlMapClientDaoSupport{

	private static Logger LOG = LoggerFactory.getLogger(GameDAO.class);

	public Game getGameById(Integer id) {
		Game game = null;
		try {
			game = (Game) getSqlMapClient().queryForObject("Game.getGameById", id);
		} catch (SQLException e){
			LOG.error("Error getting game by id: {}", e);
		}
		return game;
	}

	public Game getGameByGuid(String guid) {
		Game game = null;
		try {
			game = (Game) getSqlMapClient().queryForObject("Game.getGameByGuid", guid);
		} catch (SQLException e){
			LOG.error("Error getting game by guid: {}", e);
		}
		return game;
	}

	public GameDTO getUberGameByGuid(String guid) {
		GameDTO game = null;
		try {
			game = (GameDTO) getSqlMapClient().queryForObject("Game.getUberGameByGuid", guid);
		} catch (SQLException e){
			LOG.error("Error getting game by guid: {}", e);
		}
		return game;
	}

	public GameDTO getUberGameById(Integer id) {
		GameDTO game = null;
		try {
			game = (GameDTO) getSqlMapClient().queryForObject("Game.getUberGameById", id);
		} catch (SQLException e){
			LOG.error("Error getting game by id: {}", e);
		}
		return game;
	}

	public Game createGame() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("result", GameResult.NONE);

		Game game = null;
		try {
			Integer id = (Integer) getSqlMapClient().insert("Game.insertGame", params);
			game = getGameById(id);
		} catch (SQLException e){
			LOG.error("Error creating game: {}", e);
		}

		return game;
	}

}
