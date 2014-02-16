package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.GameDAO;
import com.richardhoppes.checkers.dto.external.ExternalGameDTO;
import com.richardhoppes.checkers.dto.internal.GameDTO;
import com.richardhoppes.checkers.exception.ServiceException;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.GamePlayer;
import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.Player;
import com.richardhoppes.checkers.model.value.Color;
import com.richardhoppes.checkers.service.util.ApiTranslationUtil;

import java.util.List;

public class GameServiceImpl implements GameService {

	GameDAO gameDAO;

	PieceService pieceService;

	PlayerService playerService;

	@Override
	public ExternalGameDTO getGameByGuid(String guid) {
		GameDTO gameDTO = gameDAO.getUberGameByGuid(guid);
		return ApiTranslationUtil.gameDTOToExternalGameDTO(gameDTO);
	}

	@Override
	public ExternalGameDTO createGame(String deviceId, Color color) throws ServiceException {
		Game game = gameDAO.createGame();

		if (game == null)
			throw new ServiceException("Error creating game");

		Player player = playerService.createPlayer(deviceId);

		if (player == null)
			throw new ServiceException("Unable to create or retrieve player.");

		GamePlayer gamePlayer = playerService.createGamePlayer(player.getId(), game.getId(), true, color);

		if (gamePlayer == null)
			throw new ServiceException("Unable to link player with game.");

		List<Piece> pieces = pieceService.createPieces(game.getId());

		if (pieces == null || pieces.size() == 0)
			throw new ServiceException("Unable to create game pieces.");

		return ApiTranslationUtil.gameDTOToExternalGameDTO(gameDAO.getUberGameById(game.getId()));
	}

	@Override
	public ExternalGameDTO joinGame(String gameGuid, String deviceId) throws ServiceException {
		GameDTO game = gameDAO.getUberGameByGuid(gameGuid);

		if (game == null)
			return null;

		if (!game.getCanJoin())
			throw new ServiceException("Game is already full.");

		Player player = playerService.createPlayer(deviceId);

		if (player == null)
			throw new ServiceException("Unable to create or retrieve player.");

		GamePlayer gamePlayer = playerService.createGamePlayer(player.getId(), game.getId(), false, game.getAvailableColor());

		if (gamePlayer == null)
			throw new ServiceException("Unable to link player with game.");

		return ApiTranslationUtil.gameDTOToExternalGameDTO(game);
	}

	/*@Override
	public ExternalGameDTO joinGame(String gameGuid, String deviceId) {
		return null;
	}*/

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

	public PieceService getPieceService() {
		return pieceService;
	}

	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}


}
