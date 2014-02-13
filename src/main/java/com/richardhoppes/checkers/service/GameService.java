package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.model.Game;

public interface GameService {

	public Game getGameById(Integer id);

	public Game getGameByGuid(String guid);

	public GameDTO getGameBoardByGuid(String gameGuid);

	public GameDTO createGame();

}
