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

	@RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
	public @ResponseBody
	GameDTO actionGetGame(@PathVariable String id) throws ResourceNotFoundException {
		GameDTO gameDto = gameService.getGameBoardByGuid(id);
		if(gameDto == null || gameDto.getGame() == null) {
			throw new ResourceNotFoundException("Game not found");
		}
		return gameDto;
	}

	@RequestMapping(value = "/game/create", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	GameDTO actionGetGame() throws ResourceNotFoundException {
		GameDTO gameDto = gameService.createGame();
		if(gameDto == null || gameDto.getGame() == null) {
			throw new ResourceNotFoundException("Error retrieving game after creation.");
		}
		return gameDto;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		super.initBinder(dataBinder);
	 }
}
