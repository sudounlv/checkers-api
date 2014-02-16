package com.richardhoppes.checkers.dao;

import com.richardhoppes.checkers.model.Piece;
import com.richardhoppes.checkers.model.value.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieceDAO extends SqlMapClientDaoSupport{

	private static Logger LOG = LoggerFactory.getLogger(PieceDAO.class);

	public List<Piece> getPiecesByGameId(Integer gameId) {
		List<Piece> pieces = null;
		try {
			pieces = (List<Piece>) getSqlMapClient().queryForList("Piece.getPiecesByGameId", gameId);
		} catch (SQLException e){
			LOG.error("Error getting pieces by game id: {}", e);
		}
		return pieces;
	}

	public Piece getPieceById(Integer id) {
		Piece piece = null;
		try {
			piece = (Piece) getSqlMapClient().queryForObject("Piece.getPieceById", id);
		} catch (SQLException e){
			LOG.error("Error getting piece by id: {}", e);
		}
		return piece;
	}

	public Piece createPiece(Integer gameId, Integer currentPosition, Color color) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gameId", gameId);
		params.put("color", color);
		params.put("isKing", 0);
		params.put("currentPosition", currentPosition);

		Piece piece = null;
		try {
			Integer id = (Integer) getSqlMapClient().insert("Piece.insertPiece", params);
			piece = getPieceById(id);
		} catch (SQLException e){
			LOG.error("Error creating piece: {}", e);
		}

		return piece;
	}

}
