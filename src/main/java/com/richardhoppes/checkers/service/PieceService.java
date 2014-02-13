package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.PieceColor;
import com.richardhoppes.checkers.model.value.PieceStatus;

import java.util.List;

public interface PieceService {

	public List<Piece> getPiecesByGameId(Integer gameId);

	public Piece getPieceById(Integer id);

	public Piece createPiece(Integer gameId, Integer currentPosition, PieceColor color);

	public List<Piece> createPieces(Integer gameId);

	public Piece updatePieceStatus(Integer id, PieceStatus status);

	public Piece updatePiecePosition(Integer id, Integer currentPosition);

	public Piece updatePieceStatusAndPosition(Integer id, PieceStatus status, Integer currentPosition);

}
