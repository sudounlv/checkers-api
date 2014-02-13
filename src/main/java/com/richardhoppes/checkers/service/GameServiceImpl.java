package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.GameDAO;
import com.richardhoppes.checkers.dto.BoardDTO;
import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.dto.LocationDTO;
import com.richardhoppes.checkers.dto.PieceDTO;
import com.richardhoppes.checkers.model.Game;
import com.richardhoppes.checkers.model.Piece;

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

		return buildGameDTO(game, pieces);
	}

	@Override
	public GameDTO createGame() {
		Game game = gameDAO.createGame();

		List<Piece> pieces = null;
		if (game != null)
			pieces = pieceService.createPieces(game.getId());

		return buildGameDTO(game, pieces);
	}

	private GameDTO buildGameDTO(Game game, List<Piece> pieces) {
		if (game == null)
			return null;

		GameDTO gameDTO = new GameDTO();
		gameDTO.setId(game.getGuid());
		gameDTO.setTurn(game.getTurn());

		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSpacesPerSide(8); // This probably won't ever change

		for (Piece piece : pieces) {
			PieceDTO pieceDTO = new PieceDTO();
			pieceDTO.setKing(piece.getKing());
			pieceDTO.setPieceColor(piece.getColor());

			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setPosition(piece.getCurrentPosition());

			pieceDTO.setLocation(locationDTO);
			boardDTO.getPieces().add(pieceDTO);
		}

		gameDTO.setBoard(boardDTO);
		return gameDTO;
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
