package com.richardhoppes.checkers.dao;

import com.richardhoppes.checkers.model.value.GameWinner;
import com.richardhoppes.checkers.model.value.GameStatus;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.value.PieceColor;
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

	public Game createGame() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("winner", GameWinner.NONE);
		params.put("status", GameStatus.IN_PROGRESS);

		Game game = null;
		try {
			Integer id = (Integer) getSqlMapClient().insert("Game.insertGame", params);
			game = getGameById(id);
		} catch (SQLException e){
			LOG.error("Error creating game: {}", e);
		}

		return game;
	}

	public Game updateGame(Integer id, GameWinner winner, GameStatus status, PieceColor turn) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		if(winner != null) {
			params.put("winner", winner);
		} else {
			params.put("winner", null);
		}

		if(status != null) {
			params.put("status", status);
		} else {
			params.put("status", null);
		}

		if(turn != null) {
			params.put("turn", turn);
		} else {
			params.put("turn", null);
		}

		Game game = null;
		try {
			getSqlMapClient().update("Game.updateGame", params);
			game = getGameById(id);
		} catch (SQLException e){
			LOG.error("Error creating game: {}", e);
		}

		return game;
	}

}
