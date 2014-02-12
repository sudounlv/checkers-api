package com.richardhoppes.checkers.controller;

import com.richardhoppes.checkers.dto.GameDTO;
import com.richardhoppes.checkers.exception.ResourceNotFoundException;
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
	GameDTO actionGetGameNoId() throws ResourceNotFoundException {
		throw new ResourceNotFoundException("Game not found");
	}

	@RequestMapping(value = "/game/{gameId}", method = RequestMethod.GET)
	public @ResponseBody
	GameDTO actionGetGame(@PathVariable String gameId)
			throws ResourceNotFoundException {

		GameDTO gameBoard = gameService.getGameBoardByGuid(gameId);
		if(gameBoard == null) {
			throw new ResourceNotFoundException("Game not found");
		}

		return gameBoard;
	}

	@RequestMapping(value = "/game/create", method = RequestMethod.GET)
	public @ResponseBody
	GameDTO actionGetGame() {
		return gameService.createGame();
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		super.initBinder(dataBinder);
	 }
}
