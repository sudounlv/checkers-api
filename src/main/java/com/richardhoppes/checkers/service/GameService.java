package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.value.GameResult;
import com.richardhoppes.checkers.model.value.GameStatus;

public interface GameService {

	public Game getGameById(Integer id);

	public Game getGameByGuid(String guid);

	public GameDTO getGameBoardByGuid(String gameGuid);

	public GameDTO createGame();

	public GameDTO updateGameResult(Integer id, GameResult result);

	public GameDTO updateGameStatus(Integer id, GameStatus status);

	public GameDTO updateGameResultAndStatus(Integer id, GameResult result, GameStatus status);

}
