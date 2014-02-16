package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.PieceDAO;
import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.Color;

import java.util.ArrayList;
import java.util.List;

public class PieceServiceImpl implements PieceService {

	private PieceDAO pieceDAO;

	@Override
	public List<Piece> getPiecesByGameId(Integer gameId) {
		return pieceDAO.getPiecesByGameId(gameId);
	}

	@Override
	public Piece getPieceById(Integer id) {
		return pieceDAO.getPieceById(id);
	}

	@Override
	public Piece createPiece(Integer gameId, Integer currentPosition, Color color) {
		Piece piece = pieceDAO.createPiece(gameId, currentPosition, color);
		if (piece == null) {
			return null;
		}
		return piece;
	}

	@Override
	public List<Piece> createPieces(Integer gameId) {
		List<Piece> pieces = new ArrayList<Piece>();
		for (int i = 1; i <= 12; i++) {
			pieces.add(createPiece(gameId, i, Color.BLACK));
		}
		for (int i = 21; i <= 32; i++) {
			pieces.add(createPiece(gameId, i, Color.RED));
		}
		return pieces;
	}

	public PieceDAO getPieceDAO() {
		return pieceDAO;
	}

	public void setPieceDAO(PieceDAO pieceDAO) {
		this.pieceDAO = pieceDAO;
	}

}
