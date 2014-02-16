package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dto.external.ExternalGameDTO;
import com.richardhoppes.checkers.exception.ServiceException;
import com.richardhoppes.checkers.model.value.Color;

public interface GameService {

	public ExternalGameDTO getGameByGuid(String gameGuid);

	public ExternalGameDTO createGame(String deviceId, Color color) throws ServiceException;

	public ExternalGameDTO joinGame(String gameGuid, String deviceId) throws ServiceException;

}
