package com.richardhoppes.checkers.service.util;

import com.richardhoppes.checkers.dto.external.ExternalBoardDTO;
import com.richardhoppes.checkers.dto.external.ExternalGameDTO;
import com.richardhoppes.checkers.dto.external.ExternalLocationDTO;
import com.richardhoppes.checkers.dto.external.ExternalPieceDTO;
import com.richardhoppes.checkers.dto.internal.GameDTO;
import com.richardhoppes.checkers.dto.internal.PieceDTO;

public class ApiTranslationUtil {

	public static ExternalGameDTO gameDTOToExternalGameDTO(GameDTO game) {
		if (game == null)
			return null;

		ExternalGameDTO externalGameDTO = new ExternalGameDTO();
		externalGameDTO.setId(game.getGuid());
		externalGameDTO.setTurn(game.getTurn());

		ExternalBoardDTO externalBoardDTO= new ExternalBoardDTO();
		externalBoardDTO.setSpacesPerSide(8); // This probably won't ever change

		for (PieceDTO piece : game.getPieces()) {
			ExternalPieceDTO externalPieceDTO = new ExternalPieceDTO();
			externalPieceDTO.setKing(piece.getKing());
			externalPieceDTO.setPieceColor(piece.getColor());

			ExternalLocationDTO locationDTO = new ExternalLocationDTO();
			locationDTO.setPosition(piece.getCurrentPosition());

			externalPieceDTO.setLocation(locationDTO);
			externalBoardDTO.getPieces().add(externalPieceDTO);
		}

		externalGameDTO.setBoard(externalBoardDTO);
		return externalGameDTO;
	}

}
