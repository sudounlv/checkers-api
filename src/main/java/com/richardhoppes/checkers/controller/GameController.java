package com.richardhoppes.checkers.controller;

import com.richardhoppes.checkers.dto.external.ExternalGameDTO;
import com.richardhoppes.checkers.exception.*;
import com.richardhoppes.checkers.exception.GameJoinException;
import com.richardhoppes.checkers.model.value.Color;
import com.richardhoppes.checkers.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController extends AbstractBaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GameService gameService;

	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public @ResponseBody
	ExternalGameDTO actionGetGameNoId() throws ResourceNotFoundException {
		throw new ResourceNotFoundException("Game not found");
	}

	@RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ExternalGameDTO actionGetGame(@PathVariable String id) throws ResourceNotFoundException {
		ExternalGameDTO gameDto = gameService.getGameByGuid(id);
		if(gameDto == null || gameDto.getId() == null) {
			throw new ResourceNotFoundException("Game not found");
		}
		return gameDto;
	}

	@RequestMapping(value = "/game/create", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ExternalGameDTO actionCreateGame(
			@RequestParam(value = "deviceId", required = false) String deviceId,
			@RequestParam(value = "color", required = false) String colorValue) throws GameCreateException, InvalidOrMissingArgument {

		if (deviceId == null)
			throw new InvalidOrMissingArgument("deviceId is required.");

		if (colorValue == null)
			throw new InvalidOrMissingArgument("color is required.");

		Color color;
		try {
			color = Color.valueOf(colorValue);
		} catch (IllegalArgumentException ex) {
			throw new InvalidOrMissingArgument("Invalid color value.");
		}

		ExternalGameDTO gameDto;
		try {
			 gameDto = gameService.createGame(deviceId, color);
		} catch (ServiceException ex) {
			throw new GameCreateException(ex.getMessage());
		}

		if(gameDto == null || gameDto.getId() == null) {
			throw new GameCreateException("Unable to retrieve game after creation.");
		}

		return gameDto;
	}

	@RequestMapping(value = "/game/{gameId}/join/{deviceId}", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ExternalGameDTO actionJoinGame(
			@PathVariable String gameId,
			@PathVariable String deviceId) throws GameJoinException {

		ExternalGameDTO gameDto;
		try {
			gameDto = gameService.joinGame(gameId, deviceId);
		} catch (ServiceException ex) {
			throw new GameJoinException(ex.getMessage());
		}

		if(gameDto == null || gameDto.getId() == null) {
			throw new GameJoinException("Unable to retrieve game.");
		}

		return gameDto;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		super.initBinder(dataBinder);
	 }
}
