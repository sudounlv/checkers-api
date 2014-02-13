package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.PieceDAO;
import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.PieceColor;
import com.richardhoppes.checkers.model.value.PieceStatus;

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
	public Piece createPiece(Integer gameId, Integer currentPosition, PieceColor color) {
		Piece piece = pieceDAO.createPiece(gameId, currentPosition, color);
		if (piece == null) {
			return null;
		}
		return piece;
	}

	@Override
	public List<Piece> createPieces(Integer gameId) {
		List<Piece> pieces = new ArrayList<Piece>();
		for (int i = 1; i <= 24; i++) {
			if (i <= 12) {
				pieces.add(createPiece(gameId, i, PieceColor.BLACK));
			} else {
				pieces.add(createPiece(gameId, i, PieceColor.RED));
			}
		}
		return pieces;
	}

	@Override
	public Piece updatePiecePosition(Integer id, Integer currentPosition) {
		Piece piece = pieceDAO.updatePiece(id, null, currentPosition);
		if (piece == null) {
			return null;
		}
		return piece;
	}

	@Override
	public Piece updatePieceStatus(Integer id, PieceStatus status) {
		Piece piece = pieceDAO.updatePiece(id, status, null);
		if (piece == null) {
			return null;
		}
		return piece;
	}

	@Override
	public Piece updatePieceStatusAndPosition(Integer id, PieceStatus status, Integer currentPosition) {
		Piece piece = pieceDAO.updatePiece(id, status, currentPosition);
		if (piece == null) {
			return null;
		}
		return piece;
	}

	public PieceDAO getPieceDAO() {
		return pieceDAO;
	}

	public void setPieceDAO(PieceDAO pieceDAO) {
		this.pieceDAO = pieceDAO;
	}

}
