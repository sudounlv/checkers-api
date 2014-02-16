package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.Color;

import java.util.List;

public interface PieceService {

	public List<Piece> getPiecesByGameId(Integer gameId);

	public Piece getPieceById(Integer id);

	public Piece createPiece(Integer gameId, Integer currentPosition, Color color);

	public List<Piece> createPieces(Integer gameId);

}
