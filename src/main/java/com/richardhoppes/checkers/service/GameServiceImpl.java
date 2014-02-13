package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.GameDAO;
import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.GameResult;
import com.richardhoppes.checkers.model.value.GameStatus;

import java.util.List;

public class GameServiceImpl implements GameService {

	GameDAO gameDAO;

	PieceService pieceService;

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
		Game game = gameDAO.getGameByGuid(guid);

		List<Piece> pieces = null;
		if (game != null)
			pieces = pieceService.getPiecesByGameId(game.getId());

		return new GameDTO(game, pieces);
	}

	@Override
	public GameDTO createGame() {
		Game game = gameDAO.createGame();

		List<Piece> pieces = null;
		if (game != null)
			pieces = pieceService.createPieces(game.getId());

		return new GameDTO(game, pieces);
	}

	@Override
	public GameDTO updateGameStatus(Integer id, GameStatus status) {
		//Game game = gameDAO.updateGame(id, null, status);
		//List<Piece> pieces = pieceService.getPiecesByGameId(id);
		//return new GameDTO(game, pieces);
		return null;
	}

	@Override
	public GameDTO updateGameResult(Integer id, GameResult result) {
		//Game game = gameDAO.updateGame(id, result, null);
		//List<Piece> pieces = pieceService.getPiecesByGameId(id);
		//return new GameDTO(game, pieces);
		return null;
	}

	@Override
	public GameDTO updateGameResultAndStatus(Integer id, GameResult result, GameStatus status) {
		//Game game = gameDAO.updateGame(id, result, status);
		//List<Piece> pieces = pieceService.getPiecesByGameId(id);
		//return new GameDTO(game, pieces);
		return null;
	}

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

}
