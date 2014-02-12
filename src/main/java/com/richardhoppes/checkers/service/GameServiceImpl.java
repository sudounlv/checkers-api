package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.GameDAO;
import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.model.value.GameResult;
import com.richardhoppes.checkers.model.value.GameStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameServiceImpl implements GameService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	GameDAO gameDAO;

	@Override
	public com.richardhoppes.checkers.model.Game getGameById(Integer id) {
		return gameDAO.getGameById(id);
	}

	@Override
	public com.richardhoppes.checkers.model.Game getGameByGuid(String guid) {
		return gameDAO.getGameByGuid(guid);
	}

	@Override
	public GameDTO getGameBoardByGuid(String guid) {
		com.richardhoppes.checkers.model.Game game = gameDAO.getGameByGuid(guid);

		// Create game board...
		return null;
	}

	@Override
	public GameDTO createGame() {
		com.richardhoppes.checkers.model.Game game = gameDAO.createGame();

		// Create game board...
		return null;
	}

	@Override
	public GameDTO updateGameStatus(Integer id, GameStatus status) {
		com.richardhoppes.checkers.model.Game game = gameDAO.updateGame(id, null, status);

		// Create game board
		return null;
	}

	@Override
	public GameDTO updateGameResult(Integer id, GameResult result) {
		com.richardhoppes.checkers.model.Game game = gameDAO.updateGame(id, result, null);

		// Create game board
		return null;
	}

	@Override
	public GameDTO updateGameResultAndStatus(Integer id, GameResult result, GameStatus status) {
		com.richardhoppes.checkers.model.Game game = gameDAO.updateGame(id, result, status);

		// Create game board
		return null;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}
